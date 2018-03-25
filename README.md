# Algorithm
JAVA를 이용하여 백준/SWExpert 문제들 해결


### 우선순위 큐 (조건 2개로 우선순위 정하기)
- arrive가 작은 순서 & arrive가 같다면 receive가 작은 순으로!

>      q = new PriorityQueue<Client>(K, new Comparator<Client>() {
>                    @Override
>                    public int compare(Client o1, Client o2) {
>                        if(o1.arrive > o2.arrive)
>                            return 1;
>                        else if(o1.arrive < o2.arrive)
>                            return -1;
>                        else{
>                            if(o1.receive > o2.receive)
>                                return 1;
>                            else if(o1.receive < o2.receive)
>                                return -1;
>                            else
>                                return 0;
>                        }
>                    }
>                });
