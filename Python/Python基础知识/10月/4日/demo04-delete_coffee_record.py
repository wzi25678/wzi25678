# 学习作者： Wzi
# 开发时间： 2022/7/20 14：05
# 学好Python，搞定大数据
'''
Traceback (most recent call last):
  File "D:\pythonProject1\Fundamental_Study\Week_01\10月4日\demo04-delete_coffee_record.py", line 31, in <module>
    main()
  File "D:\pythonProject1\Fundamental_Study\Week_01\10月4日\demo04-delete_coffee_record.py", line 12, in main
    qty = float(coffee_file.readline())
ValueError: could not convert string to float: 'Sumatra Medium Roast\n'
'''
import os
def main():
    found = False
    search = input('which coffee do you want to delete?:')
    coffee_file = open('coffee.txt','r+')
    temp_file = open('temp.txt','w+')
    descr = coffee_file.readline()
    while descr != '':
        qty = float(coffee_file.readline())
        descr = descr.rstrip('\n')
        if descr != search:
            temp_file.write(f'{descr}\n')
            temp_file.write(f'{qty}\n')
        else:
            found = True
        descr = coffee_file.readline()

    coffee_file.close()
    temp_file.close()
    os.remove('coffee.txt')
    os.rename('temp.txt','coffee_new.txt')

    if found:
        print('Tttttttttttttttttttttttttttttttt')
    else:
        print('NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN')
if __name__ == '__main__':
        main()
