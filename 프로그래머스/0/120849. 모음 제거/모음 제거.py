def solution(my_string):
    return my_string.translate({ord(letter): None for letter in 'aeiou'})