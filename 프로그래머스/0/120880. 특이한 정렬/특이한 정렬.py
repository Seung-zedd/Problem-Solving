def solution(numlist, n):
    # Sort by distance (ascending), then by number (descending) for equal distances
    return sorted(numlist, key=lambda x: (abs(x - n), -x))