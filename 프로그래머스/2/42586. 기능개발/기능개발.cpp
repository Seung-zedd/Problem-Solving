#include <iostream>
#include <vector>
#include <queue>
#include <stack>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    
    // 1. progresses for문을 돌리면서 int remained_progress = 100 - progresses[i];
    // 계산하고 remained_v로 초기화
    vector<size_t> remained_v;
    for (auto &p : progresses)
    {
        int remained_progress = 100 - p;
        remained_v.push_back(remained_progress);
    }

    queue<size_t> work_day;
    // 2. remained_v for문으로 돌리면서 remained_v[i] / speeds[i]; remained_v[i] % speeds[i]로 나머지는 day++로 이월
    for (size_t i = 0; i < remained_v.size(); i++)
    {
        // 나머지가 없으면
        //! if문은 항상 else문을 작성할 것
        if (remained_v[i] % speeds[i] == 0)
        {
            // 2.1. 그렇게 해서 work_day 큐로 각각 삽입(∵먼저 배포되어야 하는 순서대로 작업의 진도가 적힌~)
            work_day.push(remained_v[i] / speeds[i]);
        }
        else
        {
            work_day.push((remained_v[i] / speeds[i]) + 1);
        }
    }

    // 3. 뒤에 있는 놈은 앞에 있는 놈이 배포될 때 잡아먹힘
    size_t max_day = 0;
    vector<int> deploy_count;
    stack<size_t> st;
    // 각 배포마다 몇 개의 기능이 배포되는지를 return
    while (!work_day.empty())
    {

        // 너가 수문장 역할
        size_t cur_day = work_day.front();
        work_day.pop();
        // 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포
        //! 수문장이 비교 기준이 되어야 한다
        while (!st.empty() && max_day < cur_day)
        {
            deploy_count.push_back(st.size());
            stack<size_t>().swap(st);
        }
        st.push(cur_day);
        max_day = max(max_day, cur_day);
    }

    // 큐가 비고 나서 스택에 남은 물량 정산
    if (!st.empty())
    {
        deploy_count.push_back(st.size());
    }

    return deploy_count;

}