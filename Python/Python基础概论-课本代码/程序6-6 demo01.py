# 学习作者： Wzi
# 开发时间： 2022/7/20 14：05
# 学好Python，搞定大数据
def main():

    # outfile = open('philosophers.txt','w')
    # outfile.write('John Locke\n')
    # outfile.write('Happy')
    # outfile.write('GOOD\\n')
    # outfile.write('ending')
    # outfile.close()
    # John Locke     #默认不换行
    # HappyGOOD\nending
    #####################################################################################
    # infile = open('philosophers.txt','r')
    # file_contents = infile.readline()
    # line2 = infile.readline()
    # infile.close()
    #
    # print(file_contents,'end==')        #此处怎么不换行输出？
    # print(line2)
    # John Locke
    # end ==
    # HappyGOOD\nending
    #####################################################################################
    # name1 = input('Friend #1: ')
    # name2 = input('Friend #2: ')
    # name3 = input('Friend #3: ')
    # myfile = open('friends.txt','w')
    # myfile.write(name1 + '\n')
    # myfile.write(name2 + '\n')
    # myfile.write(name3 + '\n')
    #
    # myfile.close()
    # print('*********************')
    # infile = open('friends.txt','r')
    # file_contents = infile.readlines()
    # print(file_contents)
    #####################################################################################
    #读取字符串，并删除换行符
    # infile = open('philosophers.txt', 'r')
    # line1 = infile.readline()
    # line2 = infile.readline()
    # line3 = infile.readline()
    #
    #每一行结束，结尾自带一个换行符
    # line1 = line1.rsplit('\n')
    # line2 = line2.rsplit('\n')
    # line3 = line3.rsplit('\n')
    #
    # print(line1)
    # print(line2)
    # print(line3)
    #####################################################################################
    # myfile = open('friends.txt','a')
    # myfile.write('Suze\n')
    # myfile.write('shabby')    #写入时，默认不自动加换行
    # myfile.write('Good\n')
    #####################################################################################
    myfile = open('number.txt', 'w+')
    value1 = myfile.write('g o o d s ')
    value2 = open('number.txt','r',encoding='gbk')   #????
    value = value2.readline()
    myfile.close()
    print( f'{value1}：这是value1\n')   #返回字符串长度
    print( f'{value2}:这是value1\n')
    print( f'{value}:这是value\n')
    # 10：这是value1
    #
    # < _io.TextIOWrappername = 'number.txt'mode = 'r+'encoding = 'cp936' >:这是value1
    #
    # :这是value
    #
if __name__ == '__main__' :
    main()
