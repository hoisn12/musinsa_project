package com.henry.musinsa.infrastructure.config;

import com.henry.musinsa.domain.Brand;
import com.henry.musinsa.domain.Product;
import com.henry.musinsa.domain.ProductCategory;
import com.henry.musinsa.domain.User;
import com.henry.musinsa.ports.out.BrandRepositoryPort;
import com.henry.musinsa.ports.out.ProductCategoryRepositoryPort;
import com.henry.musinsa.ports.out.ProductRepositoryPort;
import com.henry.musinsa.ports.out.UserRepositoryPort;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class testDataLisnner {

    private final ProductRepositoryPort productRepository;
    private final ProductCategoryRepositoryPort productCategoryRepository;
    private final BrandRepositoryPort brandRepository;
    private final UserRepositoryPort userRepository;

    @Value("${spring.profiles.active:local}")
    private String activateOnProfile;

    @EventListener
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("===== application on load ====");
        log.info("===== active profile : {}", activateOnProfile);

        if("local".equals(activateOnProfile)) {
            List<Product> findProduct = productRepository.findAll();
            User user = userRepository.findAdmin().orElse(null);
            if (null == user) {
                user = userRepository.save(User.builder().name("admin").isAdmin(true).build());
            }

            if (findProduct.isEmpty()) {

                // 브랜드
                List<Brand> brandList = new ArrayList<>();
                brandList.add(
                        Brand.builder().title("A").description("A brand").joinDate(LocalDate.now()).creatorId(user.getId()).updaterId(user.getId())
                                .build());
                brandList.add(
                        Brand.builder().title("B").description("B brand").joinDate(LocalDate.now()).creatorId(user.getId()).updaterId(user.getId())
                                .build());
                brandList.add(
                        Brand.builder().title("C").description("C brand").joinDate(LocalDate.now()).creatorId(user.getId()).updaterId(user.getId())
                                .build());
                brandList.add(
                        Brand.builder().title("D").description("D brand").joinDate(LocalDate.now()).creatorId(user.getId()).updaterId(user.getId())
                                .build());
                brandList.add(
                        Brand.builder().title("E").description("E brand").joinDate(LocalDate.now()).creatorId(user.getId()).updaterId(user.getId())
                                .build());
                brandList.add(
                        Brand.builder().title("F").description("F brand").joinDate(LocalDate.now()).creatorId(user.getId()).updaterId(user.getId())
                                .build());
                brandList.add(
                        Brand.builder().title("G").description("G brand").joinDate(LocalDate.now()).creatorId(user.getId()).updaterId(user.getId())
                                .build());
                brandList.add(
                        Brand.builder().title("H").description("H brand").joinDate(LocalDate.now()).creatorId(user.getId()).updaterId(user.getId())
                                .build());
                brandList.add(
                        Brand.builder().title("I").description("I brand").joinDate(LocalDate.now()).creatorId(user.getId()).updaterId(user.getId())
                                .build());

                List<Brand> savedBrandList = brandRepository.saveAll(brandList);
                brandRepository.flush();
                // 카테고리
                List<ProductCategory> categoryList = new ArrayList<>();
                categoryList.add(ProductCategory.builder().title("상의").creatorId(user.getId()).updaterId(user.getId()).build());
                categoryList.add(ProductCategory.builder().title("아우터").creatorId(user.getId()).updaterId(user.getId()).build());
                categoryList.add(ProductCategory.builder().title("바지").creatorId(user.getId()).updaterId(user.getId()).build());
                categoryList.add(ProductCategory.builder().title("스니커즈").creatorId(user.getId()).updaterId(user.getId()).build());
                categoryList.add(ProductCategory.builder().title("가방").creatorId(user.getId()).updaterId(user.getId()).build());
                categoryList.add(ProductCategory.builder().title("모자").creatorId(user.getId()).updaterId(user.getId()).build());
                categoryList.add(ProductCategory.builder().title("양말").creatorId(user.getId()).updaterId(user.getId()).build());
                categoryList.add(ProductCategory.builder().title("액세서리").creatorId(user.getId()).updaterId(user.getId()).build());

                List<ProductCategory> savedCategoryList = productCategoryRepository.saveAll(categoryList);
                productCategoryRepository.flush();

                Brand brandA = savedBrandList.stream().filter(brand -> "A".equals(brand.getTitle())).findFirst().orElseThrow();
                Brand brandB = savedBrandList.stream().filter(brand -> "B".equals(brand.getTitle())).findFirst().orElseThrow();
                Brand brandC = savedBrandList.stream().filter(brand -> "C".equals(brand.getTitle())).findFirst().orElseThrow();
                Brand brandD = savedBrandList.stream().filter(brand -> "D".equals(brand.getTitle())).findFirst().orElseThrow();
                Brand brandE = savedBrandList.stream().filter(brand -> "E".equals(brand.getTitle())).findFirst().orElseThrow();
                Brand brandF = savedBrandList.stream().filter(brand -> "F".equals(brand.getTitle())).findFirst().orElseThrow();
                Brand brandG = savedBrandList.stream().filter(brand -> "G".equals(brand.getTitle())).findFirst().orElseThrow();
                Brand brandH = savedBrandList.stream().filter(brand -> "H".equals(brand.getTitle())).findFirst().orElseThrow();
                Brand brandI = savedBrandList.stream().filter(brand -> "I".equals(brand.getTitle())).findFirst().orElseThrow();

                ProductCategory categoryTop =
                        savedCategoryList.stream().filter(category -> ("상의").equals(category.getTitle())).findFirst().orElseThrow();
                ProductCategory categoryOuter =
                        savedCategoryList.stream().filter(category -> ("아우터").equals(category.getTitle())).findFirst().orElseThrow();
                ProductCategory categoryPants =
                        savedCategoryList.stream().filter(category -> ("바지").equals(category.getTitle())).findFirst().orElseThrow();
                ProductCategory categorySneakers =
                        savedCategoryList.stream().filter(category -> ("스니커즈").equals(category.getTitle())).findFirst().orElseThrow();
                ProductCategory categoryBag =
                        savedCategoryList.stream().filter(category -> ("가방").equals(category.getTitle())).findFirst().orElseThrow();
                ProductCategory categoryHat =
                        savedCategoryList.stream().filter(category -> ("모자").equals(category.getTitle())).findFirst().orElseThrow();
                ProductCategory categorySocks =
                        savedCategoryList.stream().filter(category -> ("양말").equals(category.getTitle())).findFirst().orElseThrow();
                ProductCategory categoryAccessory =
                        savedCategoryList.stream().filter(category -> ("액세서리").equals(category.getTitle())).findFirst().orElseThrow();

                List<Product> productList = new ArrayList<>();
                // A brand

                productList.add(
                        Product.builder().title(brandA.getTitle() + " " + categoryTop.getTitle()).brand(brandA).category(categoryTop).price(11200.0)
                                .salePrice(11200.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandA.getTitle() + " " + categoryOuter.getTitle()).brand(brandA).category(categoryOuter)
                        .price(5500.0).salePrice(5500.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandA.getTitle() + " " + categoryPants.getTitle()).brand(brandA).category(categoryPants)
                        .price(4200.0).salePrice(4200.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandA.getTitle() + " " + categorySneakers.getTitle()).brand(brandA).category(categorySneakers)
                                .price(9000.0).salePrice(9000.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandA.getTitle() + " " + categoryBag.getTitle()).brand(brandA).category(categoryBag).price(2000.0)
                                .salePrice(2000.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandA.getTitle() + " " + categoryHat.getTitle()).brand(brandA).category(categoryHat).price(1700.0)
                                .salePrice(1700.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandA.getTitle() + " " + categorySocks.getTitle()).brand(brandA).category(categorySocks)
                        .price(1800.0).salePrice(1800.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandA.getTitle() + " " + categoryAccessory.getTitle()).brand(brandA).category(categoryAccessory)
                                .price(2300.0).salePrice(2300.0).creatorId(user.getId()).updaterId(user.getId()).build());

                // B brand
                productList.add(
                        Product.builder().title(brandB.getTitle() + " " + categoryTop.getTitle()).brand(brandB).category(categoryTop).price(10500.0)
                                .salePrice(10500.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandB.getTitle() + " " + categoryOuter.getTitle()).brand(brandB).category(categoryOuter)
                        .price(5900.0).salePrice(5900.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandB.getTitle() + " " + categoryPants.getTitle()).brand(brandB).category(categoryPants)
                        .price(3800.0).salePrice(3800.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandB.getTitle() + " " + categorySneakers.getTitle()).brand(brandB).category(categorySneakers)
                                .price(9100.0).salePrice(9100.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandB.getTitle() + " " + categoryBag.getTitle()).brand(brandB).category(categoryBag).price(2100.0)
                                .salePrice(2100.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandB.getTitle() + " " + categoryHat.getTitle()).brand(brandB).category(categoryHat).price(2000.0)
                                .salePrice(2000.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandB.getTitle() + " " + categorySocks.getTitle()).brand(brandB).category(categorySocks)
                        .price(2000.0).salePrice(2000.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandB.getTitle() + " " + categoryAccessory.getTitle()).brand(brandB).category(categoryAccessory)
                                .price(2200.0).salePrice(2200.0).creatorId(user.getId()).updaterId(user.getId()).build());

                // C brand
                productList.add(
                        Product.builder().title(brandC.getTitle() + " " + categoryTop.getTitle()).brand(brandC).category(categoryTop).price(10000.0)
                                .salePrice(10000.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandC.getTitle() + " " + categoryOuter.getTitle()).brand(brandC).category(categoryOuter)
                        .price(6200.0).salePrice(6200.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandC.getTitle() + " " + categoryPants.getTitle()).brand(brandC).category(categoryPants)
                        .price(3300.0).salePrice(3300.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandC.getTitle() + " " + categorySneakers.getTitle()).brand(brandC).category(categorySneakers)
                                .price(9200.0).salePrice(9200.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandC.getTitle() + " " + categoryBag.getTitle()).brand(brandC).category(categoryBag).price(2200.0)
                                .salePrice(2200.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandC.getTitle() + " " + categoryHat.getTitle()).brand(brandC).category(categoryHat).price(1900.0)
                                .salePrice(1900.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandC.getTitle() + " " + categorySocks.getTitle()).brand(brandC).category(categorySocks)
                        .price(2200.0).salePrice(2200.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandC.getTitle() + " " + categoryAccessory.getTitle()).brand(brandC).category(categoryAccessory)
                                .price(2100.0).salePrice(2100.0).creatorId(user.getId()).updaterId(user.getId()).build());

                // D brand
                productList.add(
                        Product.builder().title(brandD.getTitle() + " " + categoryTop.getTitle()).brand(brandD).category(categoryTop).price(10100.0)
                                .salePrice(10100.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandD.getTitle() + " " + categoryOuter.getTitle()).brand(brandD).category(categoryOuter)
                        .price(5100.0).salePrice(5100.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandD.getTitle() + " " + categoryPants.getTitle()).brand(brandD).category(categoryPants)
                        .price(3000.0).salePrice(3000.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandD.getTitle() + " " + categorySneakers.getTitle()).brand(brandD).category(categorySneakers)
                                .price(9500.0).salePrice(9500.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandD.getTitle() + " " + categoryBag.getTitle()).brand(brandD).category(categoryBag).price(2500.0)
                                .salePrice(2500.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandD.getTitle() + " " + categoryHat.getTitle()).brand(brandD).category(categoryHat).price(1500.0)
                                .salePrice(1500.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandD.getTitle() + " " + categorySocks.getTitle()).brand(brandD).category(categorySocks)
                        .price(2400.0).salePrice(2400.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandD.getTitle() + " " + categoryAccessory.getTitle()).brand(brandD).category(categoryAccessory)
                                .price(2000.0).salePrice(2000.0).creatorId(user.getId()).updaterId(user.getId()).build());

                // E brand
                productList.add(
                        Product.builder().title(brandE.getTitle() + " " + categoryTop.getTitle()).brand(brandE).category(categoryTop).price(10700.0)
                                .salePrice(10700.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandE.getTitle() + " " + categoryOuter.getTitle()).brand(brandE).category(categoryOuter)
                        .price(5000.0).salePrice(5000.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandE.getTitle() + " " + categoryPants.getTitle()).brand(brandE).category(categoryPants)
                        .price(3800.0).salePrice(3800.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandE.getTitle() + " " + categorySneakers.getTitle()).brand(brandE).category(categorySneakers)
                                .price(9900.0).salePrice(9900.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandE.getTitle() + " " + categoryBag.getTitle()).brand(brandE).category(categoryBag).price(2300.0)
                                .salePrice(2300.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandE.getTitle() + " " + categoryHat.getTitle()).brand(brandE).category(categoryHat).price(1800.0)
                                .salePrice(1800.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandE.getTitle() + " " + categorySocks.getTitle()).brand(brandE).category(categorySocks)
                        .price(2100.0).salePrice(2100.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandE.getTitle() + " " + categoryAccessory.getTitle()).brand(brandE).category(categoryAccessory)
                                .price(2100.0).salePrice(2100.0).creatorId(user.getId()).updaterId(user.getId()).build());

                // F brand
                productList.add(
                        Product.builder().title(brandF.getTitle() + " " + categoryTop.getTitle()).brand(brandF).category(categoryTop).price(11200.0)
                                .salePrice(11200.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandF.getTitle() + " " + categoryOuter.getTitle()).brand(brandF).category(categoryOuter)
                        .price(7200.0).salePrice(7200.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandF.getTitle() + " " + categoryPants.getTitle()).brand(brandF).category(categoryPants)
                        .price(4000.0).salePrice(4000.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandF.getTitle() + " " + categorySneakers.getTitle()).brand(brandF).category(categorySneakers)
                                .price(9300.0).salePrice(9300.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandF.getTitle() + " " + categoryBag.getTitle()).brand(brandF).category(categoryBag).price(2100.0)
                                .salePrice(2100.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandF.getTitle() + " " + categoryHat.getTitle()).brand(brandF).category(categoryHat).price(1600.0)
                                .salePrice(1600.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandF.getTitle() + " " + categorySocks.getTitle()).brand(brandF).category(categorySocks)
                        .price(2300.0).salePrice(2300.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandF.getTitle() + " " + categoryAccessory.getTitle()).brand(brandF).category(categoryAccessory)
                                .price(1900.0).salePrice(1900.0).creatorId(user.getId()).updaterId(user.getId()).build());

                // G brand
                productList.add(
                        Product.builder().title(brandG.getTitle() + " " + categoryTop.getTitle()).brand(brandG).category(categoryTop).price(10500.0)
                                .salePrice(10500.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandG.getTitle() + " " + categoryOuter.getTitle()).brand(brandG).category(categoryOuter)
                        .price(5800.0).salePrice(5800.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandG.getTitle() + " " + categoryPants.getTitle()).brand(brandG).category(categoryPants)
                        .price(3900.0).salePrice(3900.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandG.getTitle() + " " + categorySneakers.getTitle()).brand(brandG).category(categorySneakers)
                                .price(9000.0).salePrice(9000.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandG.getTitle() + " " + categoryBag.getTitle()).brand(brandG).category(categoryBag).price(2200.0)
                                .salePrice(2200.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandG.getTitle() + " " + categoryHat.getTitle()).brand(brandG).category(categoryHat).price(1700.0)
                                .salePrice(1700.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandG.getTitle() + " " + categorySocks.getTitle()).brand(brandG).category(categorySocks)
                        .price(2100.0).salePrice(2100.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandG.getTitle() + " " + categoryAccessory.getTitle()).brand(brandG).category(categoryAccessory)
                                .price(2000.0).salePrice(2000.0).creatorId(user.getId()).updaterId(user.getId()).build());

                // H brand
                productList.add(
                        Product.builder().title(brandH.getTitle() + " " + categoryTop.getTitle()).brand(brandH).category(categoryTop).price(10800.0)
                                .salePrice(10800.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandH.getTitle() + " " + categoryOuter.getTitle()).brand(brandH).category(categoryOuter)
                        .price(6300.0).salePrice(6300.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandH.getTitle() + " " + categoryPants.getTitle()).brand(brandH).category(categoryPants)
                        .price(3100.0).salePrice(3100.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandH.getTitle() + " " + categorySneakers.getTitle()).brand(brandH).category(categorySneakers)
                                .price(9700.0).salePrice(9700.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandH.getTitle() + " " + categoryBag.getTitle()).brand(brandH).category(categoryBag).price(2100.0)
                                .salePrice(2100.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandH.getTitle() + " " + categoryHat.getTitle()).brand(brandH).category(categoryHat).price(1600.0)
                                .salePrice(1600.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandH.getTitle() + " " + categorySocks.getTitle()).brand(brandH).category(categorySocks)
                        .price(2000.0).salePrice(2000.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandH.getTitle() + " " + categoryAccessory.getTitle()).brand(brandH).category(categoryAccessory)
                                .price(2000.0).salePrice(2000.0).creatorId(user.getId()).updaterId(user.getId()).build());

                // I brand
                productList.add(
                        Product.builder().title(brandI.getTitle() + " " + categoryTop.getTitle()).brand(brandI).category(categoryTop).price(11400.0)
                                .salePrice(11400.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandI.getTitle() + " " + categoryOuter.getTitle()).brand(brandI).category(categoryOuter)
                        .price(6700.0).salePrice(6700.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandI.getTitle() + " " + categoryPants.getTitle()).brand(brandI).category(categoryPants)
                        .price(3200.0).salePrice(3200.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandI.getTitle() + " " + categorySneakers.getTitle()).brand(brandI).category(categorySneakers)
                                .price(9500.0).salePrice(9500.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandI.getTitle() + " " + categoryBag.getTitle()).brand(brandI).category(categoryBag).price(2400.0)
                                .salePrice(2400.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandI.getTitle() + " " + categoryHat.getTitle()).brand(brandI).category(categoryHat).price(1700.0)
                                .salePrice(1700.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(Product.builder().title(brandI.getTitle() + " " + categorySocks.getTitle()).brand(brandI).category(categorySocks)
                        .price(1700.0).salePrice(1700.0).creatorId(user.getId()).updaterId(user.getId()).build());
                productList.add(
                        Product.builder().title(brandI.getTitle() + " " + categoryAccessory.getTitle()).brand(brandI).category(categoryAccessory)
                                .price(2400.0).salePrice(2400.0).creatorId(user.getId()).updaterId(user.getId()).build());

                productRepository.saveAll(productList);
            }
        }
    }

}
