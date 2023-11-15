#   %matplotlib inline
'''
在使用 Jupyter Notebook 时，通常在代码的开头加入 %matplotlib inline，以确保在 notebook 中正确显示 Matplotlib 图形。
'''
#导包
import pandas as pd
import numpy as np
import matplotlib
matplotlib.use('TkAgg')
import matplotlib.pyplot as plt
import seaborn as sns
plt.rc('font', family='SimHei', size=13)


import os,gc,re,warnings,sys
warnings.filterwarnings("ignore")

#读取数据
# path = './data/' # 自定义的路径
path = 'D:/Programer/pycharm/MyCode/NewsRec/dataSet/' # 天池平台路径

#####train
trn_click = pd.read_csv(path+'train_click_log.csv')
# 指定哪些列是我想要读取的
# trn_click = pd.read_csv(path+'train_click_log.csv', names=['user_id','item_id','click_time','click_environment','click_deviceGroup','click_os','click_country','click_region','click_referrer_type'])
item_df = pd.read_csv(path+'articles.csv')
print("item_df")
print(item_df)
print("--------------------------------")
item_df = item_df.rename(columns={'article_id': 'click_article_id'})  #重命名，方便后续match
item_emb_df = pd.read_csv(path+'articles_emb.csv')
print("item_emb_df")
print(item_emb_df)
print("--------------------------------")
#####test
tst_click = pd.read_csv(path+'testA_click_log.csv')
print("tst_click")
print(tst_click)
print("--------------------------------")

# 数据预处理
# 计算用户点击rank和点击次数
    # 对每个用户的点击时间戳进行排序
trn_click['rank'] = trn_click.groupby(['user_id'])['click_timestamp'].rank(ascending=False).astype(int)
tst_click['rank'] = tst_click.groupby(['user_id'])['click_timestamp'].rank(ascending=False).astype(int)

    #计算用户点击文章的次数，并添加新的一列count
trn_click['click_cnts'] = trn_click.groupby(['user_id'])['click_timestamp'].transform('count')
tst_click['click_cnts'] = tst_click.groupby(['user_id'])['click_timestamp'].transform('count')

# 数据浏览
print("trn_click 数据浏览:")
df_trn_click = pd.DataFrame(trn_click)
print(df_trn_click.head(20))
print("================================")
print(df_trn_click.columns)
print(trn_click)
print("trn_click")
df_trn_click = pd.DataFrame(trn_click)
print(df_trn_click.head(20))
print("================================")
print(df_trn_click.columns)
print(trn_click)
print("--------------------------------")
print("tst_click")
print(tst_click)
print("--------------------------------")
print("item_df:")
print(item_df)
print("--------------------------------")

    #用户点击日志文件_训练集
'''
@:param 左边为trn_click,右边为item_df，，，how表示连接方式，如果是left，则左边的全保留，右边的进行全映射的配对，相同的on，则右边的其他属性和左边的属性合并merge，成一个大，新的trn_click
'''
trn_click = trn_click.merge(item_df, how='left', on=['click_article_id'])
print(trn_click.head(20))
print("================================")
print(trn_click.columns)
print("--------------------------------")

'''
train_click_log.csv文件数据中每个字段的含义:
    user_id: 用户的唯一标识
    click_article_id: 用户点击的文章唯一标识
    click_timestamp: 用户点击文章时的时间戳
    click_environment: 用户点击文章的环境
    click_deviceGroup: 用户点击文章的设备组
    click_os: 用户点击文章时的操作系统
    click_country: 用户点击文章时的所在的国家
    click_region: 用户点击文章时所在的区域
    click_referrer_type: 用户点击文章时，文章的来源
'''

#用户点击日志信息
print("-----------------------------------------------------------------------------------------------------------------")
print("trn_click.info():")
trn_click.info()

print("-----------------------------------------------------------------------------------------------------------------")
print("trn_click.describe():")
print(trn_click.describe())


#训练集中的用户数量为20w
print("训练用户数量：",end="")
print(trn_click.user_id.nunique())

print("用户最少点击文本数量：",end="")
print(trn_click.groupby('user_id')['click_article_id'].count().min() )# 训练集里面每个用户至少点击了两篇文章


# plt.figure()
# plt.figure(figsize=(15, 20))
# i = 1
# for col in ['click_article_id', 'click_timestamp', 'click_environment', 'click_deviceGroup', 'click_os', 'click_country','click_region', 'click_referrer_type', 'rank', 'click_cnts']:
#     plot_envs = plt.subplot(5, 2, i)
#     i += 1
#     v = trn_click[col].value_counts().reset_index()[:10]
#     print(v)
#     print("----------------------------------")
#     fig = sns.barplot(data=staff,x=v['index'], y=v[col],hue=)   # fig = sns.barplot(x=v['index'], y=v[col])
#     for item in fig.get_xticklabels():
#         item.set_rotation(90)
#     plt.title(col)
# plt.tight_layout()
#plt.show()
  ### 换种显示方式还是不行啊，难搞 = =~
plt.figure()
# plt.figure(figsize=(15, 20))
# i = 1
# for col in ['click_article_id', 'click_timestamp', 'click_environment', 'click_deviceGroup', 'click_os', 'click_country', 'click_region', 'click_referrer_type', 'rank', 'click_cnts']:
#     plot_envs = plt.subplot(5, 2, i)
#     i += 1
#     v = trn_click[col].value_counts().reset_index()[:10]
#     v = pd.DataFrame(v)
#     print(v)
#     print("----------------------------------")
#     fig = plt.bar(v['index'], v[col])
#     plt.xticks(rotation=90)
#     plt.title(col)
#
# plt.tight_layout()
# plt.show()

#
#
print("以用户角度分析，画出每个用户点击文章次数的直方图:")
print(trn_click['click_environment'].value_counts())

print("从点击设备组click_deviceGroup来看，设备1占大部分（61%），设备3占36%。")
print(trn_click['click_deviceGroup'].value_counts())

print("测试集用户点击日志:")
tst_click = tst_click.merge(item_df, how='left', on=['click_article_id'])
print(tst_click.head())

print("tsr_click.describe()描述:")
print(tst_click.describe())
#
#测试集中的用户数量为5w
print(tst_click.user_id.nunique()) #50000
print("测试集用户最少点击文本数量：",end="")
tst_click.groupby('user_id')['click_article_id'].count().min() # 注意测试集里面有只点击过一次文章的用户
print(tst_click.groupby('user_id')['click_article_id'].count().min() )# 训练集里面每个用户至少点击了1篇文章

# # 新闻文章信息数据表
item_df.head()._append(item_df.tail())
print("新闻文章信息数据集浏览:")
print(item_df.head(20))

# 对单词数进行记录统计
item_df['words_count'].value_counts()
print(item_df['words_count'].value_counts())

# 查看文章有多少种类型
print(item_df["category_id"].nunique())   #461
# item_df["category_id"].hist()
# 显示直方图
# x = item_df['category_id'].nunique()
# y = item_df["category_id"].hist
# plt.plot(x, y)
# plt.show()

# 用户重复点击
#####merge
user_click_merge = trn_click._append(tst_click)
print(user_click_merge.head())

#用户重复点击
user_click_count = user_click_merge.groupby(['user_id', 'click_article_id'])['click_timestamp'].agg({'count'}).reset_index()
print(user_click_count[:10])    #x或者叫“行” 显示哪些 ？    y或者叫“列”显示哪些 ？


print(user_click_count[user_click_count['count']>7])

print(user_click_count['count'].unique())

print(user_click_count.loc[:,'count'].value_counts())


# 用户点击环境变化分析
# def plot_envs(df, cols, r, c):
#     plt.figure()
#     plt.figure(figsize=(10, 5))
#     i = 1
#     for col in cols:
#         plt.subplot(r, c, i)
#         i += 1
#         v = df[col].value_counts().reset_index()
#         fig = sns.barplot(x=v['index'], y=v[col])
#         for item in fig.get_xticklabels():
#             item.set_rotation(90)
#         plt.title(col)
#     plt.tight_layout()
#     plt.show()
'''
    raise KeyError(key) from err
        KeyError: 'index'
    sns.barplot(x=v['index'], y=v[col]) 画图报错，暂时不清楚怎么解决 = =~
'''

# # 分析用户点击环境变化是否明显，这里随机采样10个用户分析这些用户的点击环境分布
# sample_user_ids = np.random.choice(tst_click['user_id'].unique(), size=10, replace=False)
# sample_users = user_click_merge[user_click_merge['user_id'].isin(sample_user_ids)]
# cols = ['click_environment','click_deviceGroup', 'click_os', 'click_country', 'click_region','click_referrer_type']
# for _, user_df in sample_users.groupby('user_id'):
#     plot_envs(user_df, cols, 2, 3)

# 用户点击新闻数量的分布
user_click_item_count = sorted(user_click_merge.groupby('user_id')['click_article_id'].count(), reverse=True)
plt.plot(user_click_item_count)
plt.show()






