import pandas as pd
from gensim.models import Word2Vec

# all_click = pd.read_csv(data_path + 'train_click_log.csv')
# print(all_click.head())

data_path = 'D:/Programer/pycharm/MyCode/NewsRec/dataSet/' # 天池平台路径
data_path = 'D:/Programer/pycharm/MyCode/NewsRec/dataSet/'
trn_click = pd.read_csv(data_path + 'train_click_log.csv')
tst_click = pd.read_csv(data_path + 'testA_click_log.csv')
user_click_merge = trn_click.append(tst_click)
click_df = user_click_merge.sort_values('click_timestamp')
click_df['click_article_id'] = click_df['click_article_id'].astype[str]
docs = click_df.groupby(['user_id'])['click_article_id'].apply(lambda x: list(x)).reset_index()
docs = docs['click_article_id'].values.tolist()
w2v = Word2Vec(docs, vector_size=16,sg=1,window=5,seed=2020,workers=24,min_count=1,epochs=10).wv

