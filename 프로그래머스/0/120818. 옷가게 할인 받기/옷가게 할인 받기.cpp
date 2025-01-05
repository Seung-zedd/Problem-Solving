#include <string>
#include <algorithm>
#include <vector>
#include <iostream>
using namespace std;

int solution(int price)
{
    // Since unordered_map does not guarantee order, a pair object is used.
    vector<pair<int, float>> discount_rules{{500000, 0.8}, {300000, 0.9}, {100000, 0.95}, {10, 1}};

    for(const auto& pair: discount_rules) {
        if (price >= pair.first) {
            return int(price * pair.second);
        }
    }
}