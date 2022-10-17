# 学习作者： Wzi
# 开发时间： 2022/7/20 14：05
# 学好Python，搞定大数据
'''
首先为了体现 queue 特性，代码中理应避免使用 Lock。
队列之于多线程，在于多任务处理时，不便创建过多线程而消耗过量资源，因此queue模块提供了同步的，线程安全的队列类。
'''
import threading
import queue
import time


class Worker(threading.Thread):
    def __init__(self, name, queue):
        threading.Thread.__init__(self)
        self.name = name
        self.queue = queue
        self.start()  # 执行run()
    def run(self):
        # 循环，保证接着跑下一个任务
        while True:
            # 队列为空则退出线程
            if self.queue.empty():
                break
            # 获取一个队列数据
            foo = self.queue.get()
            print(self.getName() + " process " + str(foo))
            # 延时1s模拟你要做的事情
            time.sleep(1)
            # 任务完成
            self.queue.task_done()


# 队列
queue = queue.Queue()
# 加入10个任务队列
for i in range(10):
    queue.put(i)
# 开3个线程
for i in range(3):
    threadName = 'Thread' + str(i)
    Worker(threadName, queue)
# 所有线程执行完毕后关闭
queue.join()
