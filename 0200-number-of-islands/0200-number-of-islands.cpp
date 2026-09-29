class Solution {

private:
    //! 컨테이너는 포인터 대신 참조값으로 전달을 한다.
    static int bfs(int x, int y, vector<vector<bool>> &visited, vector<vector<char>> &grid)
    {
        // base condition
        visited[x][y] = true;
        queue<pair<int, int>> q;
        q.push({x, y});

        // 인접 노드 탐색
        while (!q.empty())
        {
            // 현재 위치 탐색
            pair<int, int> cur_node = q.front();
            int x = cur_node.first;
            int y = cur_node.second;
            q.pop();

            vector<int> dx{-1, 0, 1, 0};
            vector<int> dy{0, 1, 0, -1};

            //! 프로그래머스 방향키 문제 템플릿. 즉, for문을 dx, dy 별개로 돌리는 것이 아니라 하나의 루프 안에서 처리를 한다.
            for (int k = 0; k < 4; k++)
            {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 경계 조건 작성
                if (nx >= 0 && nx < grid.size() && ny >= 0 && ny < grid[0].size())
                {
                    if (!visited[nx][ny] && grid[nx][ny] == '1')
                    {
                        visited[nx][ny] = true;
                        q.push({nx, ny});
                    }
                }
            }
        }
        return 1;
    }

public:
    int numIslands(vector<vector<char>> &grid)
    {
        // 1. m = grid.size(); n = grid[0].size()으로 초기화
        int m = grid.size();
        int n = grid[0].size();

        // 원본 grid 데이터 오염 방지 위해 boolean 타입 visited 초기화
        //! vector<vector<bool>> visited(grid.size());는 내부 벡터가 비어있기 때문에 vector<vector<bool>> visited(m, vector<bool>(n, false));로 초기화할 것!
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        int count = 0;

        // 2. 2중 for문으로 grid 순회:
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                // 2.1. if (visited[i][j] == false && grid[i][j] == '1'): bfs(i, j)
                if (!visited[i][j] && grid[i][j] == '1')
                {
                    count += bfs(i, j, visited, grid);
                }
            }
        }

        return count;
    }
};