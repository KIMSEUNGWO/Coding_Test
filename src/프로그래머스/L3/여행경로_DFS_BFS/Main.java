package 프로그래머스.L3.여행경로_DFS_BFS;

import 프로그래머스.component.Confirm;

public class Main {

    private static final String[][][] ticketList = {
        {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}},
        {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}},
        {{"ICN", "D"}, {"D", "ICN"}, {"ICN", "B"}}
    };

    private static final String[][] returnValue = {
        {"ICN", "JFK", "HND", "IAD"},
        {"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"},
        {"ICN", "D", "ICN", "B"}
    };

    private static final Logic logic = new Logic();

    public static void main(String[] args) {

        for (int i = 0; i < ticketList.length; i++) {
            String[] myResult = logic.solution(ticketList[i]);
            Confirm.confirm(returnValue[i], myResult);
        }

    }
}
