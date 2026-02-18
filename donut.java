import java.util.*;
public class donut {
    public static void main(String[] args) {
        // PaizaのBランク問題　B:138　ドーナツのコード
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        String line =sc.nextLine();
        char[][] geoglyphs = new char[h][w];
        int cnt=0;
        for(int i=0;i<h;i++){
            String e = sc.nextLine();
            for(int j=0;j<w;j++){
                geoglyphs[i][j] = e.charAt(j);
            }
        }
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                int w_cnt =1;
                int h_cnt =1;
                if(geoglyphs[i][j] == '#' && i < h-2 && j < w-2){
                    int k = i;
                    int l = j;
                    while(true){
                        if(k == h-1 && l == w-1 && w_cnt != 3 && h_cnt != 3){
                            break;
                        }
                        if(w_cnt < 3 && h_cnt == 1 && geoglyphs[k][l+1] == '#'){
                            w_cnt++;
                            l++;
                        }else if(w_cnt == 3 && h_cnt < 3 && geoglyphs[k+1][l] == '#'){
                            h_cnt++;
                            k++;
                        }else if(w_cnt ==3 && h_cnt ==3 && geoglyphs[k][l-1] == '#'){
                            if(geoglyphs[k][l-2] =='#'){
                                if(geoglyphs[k-1][l-2] == '#'){
                                    if(geoglyphs[k-1][l-1] =='.'){
                                        cnt++;
                                    }
                                    break;
                                }
                                break;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}