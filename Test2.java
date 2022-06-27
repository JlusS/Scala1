import scala.Int;
import scala.runtime.Static;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Test2 {
    static HashMap<String, Integer> citiesNames;


    static class City{
        int id = 0;
        int cost = 0;
        public City(int id, int cost){
            super();
            this.id = id;
            this.cost = cost;
        }
    }

    //Dijkstra's algorithm
    static void Dijkstra(int source, ArrayList<City>[] adj, int[] dist){
        PriorityQueue<City> pq = new PriorityQueue<>(new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.cost- o2.cost;
            }
        });
        pq.add(new City(source,0));
        dist[source] = 0;
        while (!pq.isEmpty()){
            City top = pq.poll();
            if(top.id==destination) break;
            for (City neighbour : adj[top.id]){
                int cost_new = neighbour.cost + top.cost;
                if (cost_new<dist[neighbour.id]){
                        pq.add(new City(neighbour.id,cost_new));
                                dist[neighbour.id] = cost_new;
                }
            }
        }
    }
    static int destination;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();      //read first line
        int s = Integer.parseInt(line);

        for (int testTimes = 0; testTimes < s; testTimes++) {
            line = sc.nextLine();
            int n = Integer.parseInt(line);    //read second line
            citiesNames = new HashMap<>();      //HashMap of cities with id

            ArrayList<City>[] adj = new ArrayList[n+1];       //New ArrayList (City index, Cost of the trip)

            for(int city=1;city<=n;city++) adj[city] = new ArrayList<>();
            for (int city = 0; city < n; city++) {
                line = sc.nextLine();
                String name = line;        //read third line
                line = sc.nextLine();
                int p = Integer.parseInt(line);
                for (int neighbor = 0; neighbor < p; neighbor++) {
                    line = sc.nextLine();      //read fourth line with city index and cost of the trip
                    String[] nrCost = line.split(" ");
                    int nr = Integer.parseInt(nrCost[0]);     //city index
                    int Cost = Integer.parseInt(nrCost[1]);   //cost of the trip
                    adj[neighbor+1].add(new City(nr,Cost));       //add class City values to ArrayList
                }
                citiesNames.put(name, city + 1);    //Put cities names and generate id
            }
            line = sc.nextLine();
            int r = Integer.parseInt(line);


            for (int wtg1 = 1; wtg1 <= r; wtg1++) {
                line = sc.nextLine();     //read fifth line
                String[] names = line.split(" ");
                String wf = names[0];      // Where from index
                String wtg = names[1];     // Where to go index
                int fromWhere = citiesNames.get(wf);
                int toWhere = citiesNames.get(wtg);
                destination = toWhere;
                int[] dist = new int[n+1];
                Arrays.fill(dist,Integer.MAX_VALUE);
                Dijkstra(fromWhere,adj,dist);
                System.out.println(dist[toWhere]);
            }
        }
    }

}