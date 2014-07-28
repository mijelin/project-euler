"""
SUM SQUARE DIFFERENCE
The sum of the squares of the first ten natural numbers is:
                        1^2 + 2^2 + ... + 10^2 = 385
The square of the sum of the first ten natural numbers is:
                    (1 + 2 + ... + 10)^2 = 552 = 3025
Hence the difference between the sum of the squares of the first ten natural
numbers and the square of the sum is 3025 - 385 = 2640.

Find the difference between the sum of the squares of the first one hundred
natural numbers and the square of the sum.
@author Michelle Lin
"""

def sumOfSquares(num):
    """Returns the sum of the squares of natural numbers up to NUM, inclusive.
    >>> sumOfSquares(10)
    385
    >>> sumOfSquares(3)
    14
    >>> sumOfSquares(0)
    0
    """
    sum = 0
    for i in range(1, num + 1):
        sum += i ** 2
    return sum

def squareOfSum(num):
    """Returns the square of the sum of natural numbers up to NUM, inclusive.
    >>> squareOfSum(10)
    3025
    >>> squareOfSum(0)
    0
    >>> squareOfSum(4)
    100
    """
    return sum(range(1, num + 1)) ** 2

def findDifference(num):
    """
      Returns the difference between the sum of squares of the first NUM
      natural numbers and the square of the sum.
      >>> findDifference(10)
      2640
    """
    return squareOfSum(num) - sumOfSquares(num)


print("The difference is %d" % findDifference(100))
