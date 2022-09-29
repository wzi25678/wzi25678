# 学习作者： Wzi
# 开发时间： 2022/7/20 14：05
# 学好Python，搞定大数据
# import turtle
# turtle.showturtle()
# turtle.done()
# import turtle
# for num in range(1,9):
#     turtle.forward(50)
#     turtle.left(45)
#     num+=1
# turtle.done()

#    程序4-21   concentric_circles.py
#    Concentric circles
# import turtle
# NUM_CIRCLES = 45
# STARTING_RADIUS = 20
# OFFSET = 10
# ANIMATION_SOEED = 0
# turtle.speed(ANIMATION_SOEED)
# turtle.hideturtle()
# radius = STARTING_RADIUS
# for count in range(NUM_CIRCLES) :
#    turtle.circle(radius)
#    x = turtle.xcor()
#    y = turtle.ycor()-OFFSET    #turtle.circle(radius)是以当前位置为圆的正下角，逆时针绕一个以radius为半径的圆
#    radius = radius +OFFSET
#    turtle.penup()
#    turtle.goto(x,y)
#    turtle.pendown()
# turtle.done()
import turtle
NUM_CIRCLES = 36
RADIUS = 100
ANGLE = 10
ANIMATION_SPEED = 0;
turtle.speed(ANIMATION_SPEED)
for x in range(NUM_CIRCLES) :
    #turtle.fillcolor('red')
    turtle.circle(RADIUS)
    turtle.left(ANGLE)

turtle.done()

