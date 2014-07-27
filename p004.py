"""
A palindromic number reads the same both ways. The largest palindrome made from
the product of two 2-digit numbers is 9009 = 91 x 99.
Find the largest palindrome made from the product of two 3-digit numbers.
@author Michelle Lin
"""

class FindPalindrome:

    def __init__(self):
        self.largest = 0

    def isPalindrome(self, num):
        """Returns true iff NUM is a palindrome.
        >>> x = FindPalindrome()
        >>> x.isPalindrome(9009)
        True
        >>> x.isPalindrome(456)
        False
        """
        numStr = str(num)
        return numStr[::-1] == numStr

    def find(self):
        i = 999
        while i > 99:
            j = 999
            while j > 99:
                prod = i * j
                if self.isPalindrome(prod):
                    self.largest = max(self.largest, prod)
                j -= 1
            i -= 1

    def getLargest(self):
        return self.largest

x = FindPalindrome()
x.find()
print("The largest palindrome is %d" % x.getLargest())

