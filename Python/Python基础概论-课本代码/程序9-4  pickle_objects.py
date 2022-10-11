# # 学习作者： Wzi
# # 开发时间： 2022/7/20 14：05
# # 学好Python，搞定大数据
#
# #outputfile = open('MyDate.dat','wb')
# # import pickle
# # phonebook = {'Chris' : '555-1111',
# #              'Katie' : '555-2222',
# #              'Joanne' : '555-3333'}
# # output_file = open('phonebook.dat','wb')    #以二进制形式给它展开
# # pickle.dump(phonebook,output_file)
# # output_file.close()
#
# # import pickle
# # input_file = open('phonebook.dat','rb')
# # pb = pickle.load(input_file)        #要以重载形式来打开文件夹
# # print(pb)
# # #{'Chris': '555-1111', 'Katie': '555-2222', 'Joanne': '555-3333'}
#
# #   程序9-4  pickle_objects.py
# import os.path
# import pickle
#
#
# def save_data(output_file):
#     person = {}
#     person['name'] = input('Name:')
#     person['age'] = int(input('Age:'))
#     person['weight'] = float(input('Weight:'))
#     pickle.dump(person,output_file)
#
#
# def main():
#     again = 'y'
#     output_file = open('info.dat','wb')
#     while again.lower() == 'y' :
#         save_data(output_file)
#         again = input('Enter more data?(y/n)')
#     infoUnpackle = open('info.dat', 'rb')
#     if os.path.getsize(infoUnpackle)>0 :
#          output_file = pickle.load(infoUnpackle)
#          print(output_file)
#     else:
#         print('EOFError: Ran out of input')
#     output_file.close()
#
# if __name__ == '__main__':
#         main()
# # Name:Angie
# # Age:25
# # Weight:122
# # Enter more data?(y/n)y
# # Name:deng
# # Age:18
# # Weight:99
