# 学习作者： Wzi
# 开发时间： 2022/7/20 14：05
# 学好Python，搞定大数据
import random


def main():
    #Create a deck of cards.
    deck = create_deck()

    #Get the number of cards to deal
    num_cards = int(input('How mang cards should I deal?\n'))

    #Deal the cards
    deal_cards(deck,num_cards)


def create_deck():
    deck = {'Ace of Spades':1,'2 of Spades':2,'3 of Spades':3,'4 of Spades':4,'5 of Spades':5,'6 of Spades':6,
            'Ace of Hearts':1,'2 of Hearts':2,'3 of Hearts':3,'4 of Hearts':4,'5 of Hearts':5,'6 of Hearts':6,
            'Ace of Clubs':1,'2 of Clubs':2,'3 of Clubs':3,'4 of Clubs':4,'5 of Clubs':5,'6 of Clubs':6,
            'Ace of Diamonds':1,'2 of Diamonds':2,'3 of Diamonds':3,'4 of Diamonds':4,'5 of Diamonds':5,'6 of Diamonds':6}
    return deck

def deal_cards(deck,numbers):
    #Initialize an accumulator for the hand value
    hand_value = 0
    if numbers>len(deck):
        numbers = len(deck)

    for count in range(numbers):
        card = random.choice(list(deck))
        print(card)
        hand_value += deck[card]

    print(f'Value of this hand：{hand_value}')
if __name__ == '__main__':
        main()
