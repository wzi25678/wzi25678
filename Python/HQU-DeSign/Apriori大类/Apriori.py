import pandas as pd
from itertools import chain, combinations
from tqdm import tqdm

data1 = pd.read_csv('E:/dataSet/movies/ml-1m/ratings.dat',sep='::',header=0,engine='python')
data1.columns = ['userID', 'moviesID', 'rating', 'timestamp']
# 提取前两列，即userID和moviesID
user_movie_data = data1[['userID', 'moviesID']]

# 将数据转换成 DataFrame
dfData1 = pd.DataFrame(data1, columns=['userID', 'moviesID'])
# # 使用 pandas 的 pivot_table 方法进行透视
# user_movie_matrix = pd.pivot_table(dfData1, index='userID', columns='moviesID', aggfunc=lambda x: 1, fill_value=0)

# # 打印透视后的数据
# print(user_movie_matrix)
# 使用 groupby 和 agg 将每个用户的电影ID合并成一个列表
user_movies = dfData1.groupby('userID')['moviesID'].agg(list).reset_index()

# 打印透视后的数
print(user_movies)

# 将moviesID列中的列表转换为集合
# dfData1['moviesID_set'] = dfData1['moviesID'].apply(set)
user_movies['moviesID_set'] = user_movies['moviesID'].apply(set)
user_movies['moviesID_set']
# # 打印转换后的数据
for index, row in user_movies.iterrows():
    print(row['moviesID_set'])

# 生成候选项集的所有非空子集
def powerset(s):
    return chain.from_iterable(combinations(s, r) for r in range(1, len(s)))
# 计算支持度
def calculate_support(itemset, transactions):
    return sum(1 for transaction in transactions if itemset.issubset(transaction)) / len(transactions)

def apriori(transactions, min_support, min_confidence):
    # 初始化频繁项集和关联规则列表
    frequent_itemsets = []
    association_rules = []
    # 第一步：找出单项频繁项集
    singletons = {frozenset([item]) for transaction in transactions for item in transaction}
    singletons = {itemset for itemset in singletons if calculate_support(itemset, transactions) >= min_support}
    print("此处以运行。01")
    frequent_itemsets.extend(singletons)
    # 迭代找出所有其他频繁项集
    prev_frequent_itemsets = singletons
    while prev_frequent_itemsets:
        # 生成新的候选项集
        candidates = {itemset1 | itemset2 for itemset1 in tqdm(prev_frequent_itemsets) for itemset2 in prev_frequent_itemsets if len(itemset1 | itemset2) == len(itemset1) + 1}
        print("卡在哪儿呢？04")
        # 计算支持度并筛选
        new_frequent_itemsets = {itemset for itemset in tqdm(candidates) if calculate_support(itemset, transactions) >= min_support}
        print("卡在哪儿呢？05")
        frequent_itemsets.extend(new_frequent_itemsets)
        # 生成关联规则1
        for itemset in tqdm(new_frequent_itemsets):
            for subset in powerset(itemset):
                subset = frozenset(subset)
                diff = itemset - subset
                print("gan!gan!gan!")
                if diff:
                    confidence = calculate_support(itemset, transactions) / calculate_support(subset, transactions)
                    if confidence >= min_confidence:
                        association_rules.append((subset, diff, confidence))
        print("死机了？01")
        prev_frequent_itemsets = new_frequent_itemsets
        print("死机了？02")
    print("难道是这儿？")
    return frequent_itemsets, association_rules


all_sets1 = []

# 遍历每一行并将集合添加到列表中
for row in tqdm(user_movies['moviesID_set']):
    all_sets1.append(row)

print(all_sets1)


transactions = all_sets1

import time

# 记录开始时间
start_time = time.time()
print("开始执行！")
# 运行你的代码或任务
# ...
min_support = 0.5
min_confidence = 0.5
'''
    实验记录：   0.3   0.4时：    程序运行时长：2.801751136779785 秒 
               0.2   0.4时：    22.47648334503174 秒
               0.2   0.3时：    程序运行时长：22.416706562042236 秒
               0.2   0.5：      程序运行时长：22.719205856323242 秒
               0.1   0.5：      
               

'''
print("进不去，，，，，，")
frequent_itemsets, association_rules = apriori(transactions, min_support, min_confidence)
print("出不来。。。。。。")
print("频繁项集：", frequent_itemsets)
print("关联规则：", association_rules)
# 记录结束时间
end_time = time.time()

# 计算运行时长
duration = end_time - start_time

# 打印运行时长
print(f"程序运行时长：{duration} 秒")


