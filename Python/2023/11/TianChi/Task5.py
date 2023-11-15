import numpy as np
import pandas as pd
import pickle
from tqdm import tqdm
import gc, os
import time
from datetime import datetime
import lightgbm as lgb
from sklearn.preprocessing import MinMaxScaler
import warnings
warnings.filterwarnings('ignore')

# 加载数据data_path = './data_raw/'
data_path = 'D:/Programer/pycharm/MyCode/NewsRec/dataSet/' # 天池平台路径
save_path = 'D:/Programer/pycharm/MyCode/NewsRec/resultSet/'  # 天池平台路径
offline = False

# 重新读取数据的时候，发现click_article_id是一个浮点数，所以将其转换成int类型
trn_user_item_feats_df = pd.read_csv(save_path + 'trn_user_item_feats_df.csv')
trn_user_item_feats_df['click_article_id'] = trn_user_item_feats_df['click_article_id'].astype(int)

if offline:
    val_user_item_feats_df = pd.read_csv(save_path + 'val_user_item_feats_df.csv')
    val_user_item_feats_df['click_article_id'] = val_user_item_feats_df['click_article_id'].astype(int)
else:
    val_user_item_feats_df = None

tst_user_item_feats_df = pd.read_csv(save_path + 'tst_user_item_feats_df.csv')
tst_user_item_feats_df['click_article_id'] = tst_user_item_feats_df['click_article_id'].astype(int)

# 做特征的时候为了方便，给测试集也打上了一个无效的标签，这里直接删掉就行
del tst_user_item_feats_df['label']


