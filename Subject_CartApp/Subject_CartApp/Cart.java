import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cart {
    private HashMap<Product,Integer> list;

    public Cart() {
        list = new HashMap<>();
    }

    public void showItems(){
        StringBuilder sb = new StringBuilder();
        sb.append("==========장바구니 목록==========\n");
        for(Product p :  list.keySet()){
            sb.append(p.getName())
                    .append("의 수량은 ")
                    .append(list.get(p))
                    .append("개 입니다.")
                    .append('\n');

        }
        sb.append("===============================\n");
        System.out.println(sb.toString());
    }

    public void addProduct(Product product,int plusAmount){
        if(list.containsKey(product)) {
            int beforeAmount = list.get(product);
            list.put(product,beforeAmount + plusAmount);
        }else{
            list.put(product,plusAmount);
        }
        System.out.println(product.getName()+"를 "+plusAmount+"개를 장바구니에 담았습니다.");
    }

    public boolean removeProduct(Product product,int removeAmount){
        if (list.containsKey(product)){
            int remainAmount = list.get(product) - removeAmount;
            if(remainAmount < 0){
                return false;
            }else{
                list.put(product,removeAmount);
                System.out.println(product.getName()+"를 "+removeAmount+"개를 장바구니에서 뺐습니다.");
                return true;
            }

        }else{
            return false;
        }
    }
}
