# musinsa_project

### 환경
### database: H2
### java: 17

### 설명
- 폴더 구조는 포트어댑터(핵사고날) 아키텍처 기반으로 설계하였습니다.
- 추상화를 통해 확장성 및 유연하게 변경가능한 아키텍처라고 생각되어 채택하였습니다.
- 상품 테이블, 브랜드 테이블, 카테고리 테이블이 있으며, 상품은 price(원가), sale_price(할인가) 가 있고 sale_price 기준으로 계산되었습니다.
- spring boot 3, JPA, queryDSL, mapStruct 가 사용되었습니다.

빌드방법: 소스 폴더에서 ./gradlew build 

실행방법: java -jar ./build/libs/musinsa-0.0.1-SNAPSHOT.jar  

테스트방법: 상품 데이터는 Application 실행시 자동으로 H2 database에 등록됩니다. 각 API들을 호출하시기만 하면 됩니다.
브랜드/상품 수정의 경우 생성 후 return 되는 id로 수정을 해주셔야합니다.

### 디렉터리 구조
#### adapters
- 사용자 인터페이스나 API, 데이터베이스등을 처리하는 부분입니다.
#### application
- 도메인 모델을 조작하거나 비즈니스 로직을 구현하는 폴더
#### common
- 공통 모듈이 있는 폴더
#### domain
- 핵심 비즈니스 로직이 있는 폴더
#### infrastructure
- 프레임워크와 관련된 환경설정이나 모듈
#### ports
- 도메인에서 외부로 나가거나(in) 외부에서 도메인으로 들어오는 인터페이스 정의 폴더

## 구현 API
### 카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API
```
GET http://localhost:8081/api/products/prices/lowest/category
```
### 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API
```
GET http://localhost:8081/api/products/prices/lowest/brand
```
### 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API
```
GET http://localhost:8081/api/products/category/lowhigh?name=상의
```
### 브랜드 및 상품을 추가 / 업데이트 / 삭제하는 API
### 브랜드 등록
```
POST http://localhost:8081/api/brands
body : {
"title": "brand 33",
"joinDate": "20241015"
"description": "test"
}
```
### 브랜드 수정
```
PUT http://localhost:8081/api/brands
body : {
"id": "44f1cee27a6e472a8470a059b5b18dcd",
"title": "bra",
"description": null,
"joinDate": "20241015"
}
```
### 브랜드 삭제
```
DELETE http://localhost:8081/api/brands/4b22483081ee4d0ca6ebdd08fb06ac41
```

### 상품등록
```
POST http://localhost:8081/api/products
body : {
"title": "test",
"brandId": "4bcf18ec475441cdb4df221794692814",
"categoryId": "15b70eae642d4a3790fc2302d179594a",
"price": 11000,
"salePrice": 11000
}
```
### 상품수정
```
PUT http://localhost:8081/api/products
body : {
"id": "41ca22194d1d413381a1935fb39aa4bf"
"title": "test",
"brandId": "4bcf18ec475441cdb4df221794692814",
"categoryId": "15b70eae642d4a3790fc2302d179594a",
"price": 11000,
"salePrice": 11000
}
```
### 상품삭제
```
DELETE http://localhost:8081/api/products/4b22483081ee4d0ca6ebdd08fb06ac41
```
### 카테고리 조회
```
GET http://localhost:8081/api/category
```