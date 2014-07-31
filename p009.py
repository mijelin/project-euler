import timeit

"""
SPECIAL PYTHAGOREAN TRIPLET
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
                                a^2 + b^2 = c^2
For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
@author Michelle Lin
"""

def findTripletNaive():
    """Uses 'a < b < c' property and iteratively searches for solution."""
    for a in range(0, 1001):
        for b in range(a + 1, 1001):
            for c in range(b + 1, 1001):
                if (a + b + c == 1000) and (a**2 + b**2 == c**2):
                    print("a: %d, b: %d, c: %d" % (a, b, c))
                    print("%d * %d * %d = %d" % (a, b, c, a * b * c))
                    break

def findTripletRange():
    """Uses 'a < b < c' and 'a + b + c = 1000' properties."""
    for a in range(0, 1001):
        for b in range(a + 1, 1000 - a + 1):
            for c in range(b + 1, 1000 - a - b + 1):
                if (a + b + c == 1000) and (a**2 + b**2 == c**2):
                    print("a: %d, b: %d, c: %d" % (a, b, c))
                    print("%d * %d * %d = %d" % (a, b, c, a * b * c))
                    break

findTripletRange()

naive = timeit.Timer('findTripletNaive', 'from __main__ import findTripletNaive')
range = timeit.Timer('findTripletRange', 'from __main__ import findTripletRange')

print("Naive method took " + str(naive.timeit()) + " microseconds")

print("Optimized method took " + str(range.timeit()) + " microseconds")
