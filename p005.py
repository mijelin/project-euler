"""
SMALLEST MULTIPLE
2520 is the smallest number that can be divided by each of the numbers from
1 to 10 without any remainder.
What is the smallest positive number that is evenly divisible by all of the
numbers from 1 to 20?
@author Michelle Lin
"""

# Checking divisibility by 20, 19, 18, 17, 16, 15, 14, 13, 12, 11 is sufficient.

set = [ 20, 19, 18, 17, 16, 15, 14, 13, 12, 11 ]

def checkDivisible(num, set):
    """Returns true iff NUM is divisible by all the numbers in SET."""
    for n in set:
        if not num % n == 0:
            return False
    return True

def find():
    """Prints the smallest positive number divisible by numbers 1-20. """
    num = 20
    while not checkDivisible(num, set):
        num += 20
    print("The smallest such number is %d" % num)

find()
