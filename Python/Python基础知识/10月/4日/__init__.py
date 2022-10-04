# 学习作者： Wzi
# 开发时间： 2022/7/20 14：05
# 学好Python，搞定大数据
def main():
    num_emps = int(input("How many employees record"+
                         "do you want to create ?\n"))
    emp_file = open('employees.txt','w+')
    for count in range(1,num_emps + 1):
        print("请开始输入:\n")
        print(f'Enter data for your empluyees #{count}')
        name = input('name: ')
        id_num = input('ID number: ')
        dept = input('dept: ')

        emp_file.write(f'{name}\n')
        emp_file.write(f'{id_num}\n')
        emp_file.write(f'{dept}\n')

    emp_file.close()
    print('=================================================================')

if __name__ == '__main__':
     main()
