import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CartApp {
    public static void main(String[] args) {
        // 상품 목록 생성
        Set<Product> productSet = new HashSet<>();
        // TODO: 상품 클래스를 생성하여 상품목록에 넣는다.
        for(Product product : readCSV("./ProductList.csv")){
            productSet.add(product);
        }
        List<Product> test = productSet.stream().toList();

        // 상품 목록 확인
        System.out.println("고유한 상품 목록:");
        for (Product product : productSet){
            System.out.println(product.getName() + " : "+product.getPrice());
        }

        Cart myCart = new Cart();

        // TODO: 상품을 장바구니에 추가
        myCart.addProduct(test.get(0), 2);
        myCart.addProduct(test.get(1), 6);

        // TODO: 상품을 장바구니에서 제거
        myCart.removeProduct(test.get(1),2);
        
        // TODO: 장바구니에 현재 단긴 상품들을 출력 (상품이름, 각 성품의 객수)
        myCart.showItems();

    }

    public static List<Product> readCSV(String fileName) {
        List<Product> productList = new ArrayList<>();
        File csv = new File(fileName);
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) {
                String[] content = line.split(",");

                productList.add(
                        new Product(
                                Integer.parseInt(content[0].replaceAll("[^0-9]+","")),
                                content[1],
                                Double.parseDouble(content[2])
                        )
                );
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch(IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return productList;
    }
}

