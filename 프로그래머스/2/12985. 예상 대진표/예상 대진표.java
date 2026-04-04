class Solution
{
    public int solution(int n, int a, int b)
    {
        //? solution()의 정의: a와 b는 도대체 몇 라운드에 만날 것인가?
        // base condition
        // a와 b의 다음 라운드 번호가 같을 때(즉, 이번에 맞붙을 때), 더 이상 남은 라운드는 없고 이번 1경기로 끝난다.
        if ((a + 1) / 2 == (b + 1) / 2) {
            return 1;
        }

        // ?의 정체: ?는 현재 내 상태를 의미함, 즉 전체적인 F(n)은 모르겠고 지금 내가 여기서 1경기를 치렀으니 전체 라운드 수에 1만큼 기여했다. 
        // F(next)의 정체: 다음 라운드 번호로 바뀐 애들 (a+1)/2, (b+1)/2이 만나는 건 다음 함수 네가 알아서 계산해서 가져와!
        return 1 + solution(n, (a + 1) / 2, (b + 1) / 2); 
    }
}