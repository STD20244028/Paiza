import java.util.*;
import java.util.Map;
import java.util.HashMap;
public class many {
    public static void main(String[] args) {
        // PaizaのBランク問題　B:157　節約魂のコード
        Scanner sc = new Scanner(System.in);
        int[] nk =Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n =nk[0];
        int k =nk[1];
        int[][] supermarket =new int[n][k];
        for(int i=0;i<n;i++){
            int[] price =Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0;j<k;j++){
                supermarket[i][j] = price[j];
            }
        }
        Map<Integer,Integer> shop = new HashMap<>();
        int[] shop_buy = new int[k];
        int min =0;
        int wk=0;
        for(int j=0;j<k;j++){
            for(int i=0;i<n;i++){
                if(i==0){
                    min = supermarket[i][j];
                    shop_buy[j] = i;
                }else if(min > supermarket[i][j]){
                    min = supermarket[i][j];
                    shop_buy[j] = i;
                }
            }
            if(shop.containsKey(shop_buy[j]) == true){
                wk=shop.get(shop_buy[j]);
                wk++;
                shop.put(shop_buy[j],wk);
            }else{
                shop.put(shop_buy[j],1);
            }
        }
        System.out.println(shop.size());
    }
}