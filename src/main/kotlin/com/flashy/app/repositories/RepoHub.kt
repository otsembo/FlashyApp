package com.flashy.app.repositories

import com.flashy.app.models.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import javax.transaction.Transactional

interface BrandRepository : JpaRepository<Brand, Int>

interface AddressRepository: JpaRepository<Address, Int>

interface CountryRepository: JpaRepository<Country, Int>

interface CartRepository: JpaRepository<Cart, Int>{

    @Query(value = "SELECT * FROM cart c WHERE c.is_checked = 0 AND c.user_id = ?1 AND c.is_deleted != 1", nativeQuery = true)
    fun findActiveCart(id:Int) : List<Cart>

}

interface CategoryRepository: JpaRepository<Category, Int>

interface FavoriteRepository: JpaRepository<Favorite, Int>{

    @Query(value = "SELECT * FROM favorites f WHERE f.user_id =?1 AND f.is_removed = 0", nativeQuery = true)
    fun findActiveFavorite(id:Int) : List<Favorite>

    @Modifying
    @Transactional
    @Query(value = "UPDATE favorites f SET  f.is_removed = 1 WHERE f.user_id = ?1 AND f.id = ?2", nativeQuery = true)
    fun removeFav(userId:Int, favId:Int)

}

interface UserRepository: JpaRepository<User, Int>

interface ProductRepository: JpaRepository<Product, Int>{

    @Query(value = "SELECT * FROM products p  WHERE p.qty_available > 0  ORDER BY p.date DESC LIMIT 10", nativeQuery = true)
    fun getLatestProducts() : List<Product>

}

interface ImagesRepository : JpaRepository<Images, Int>{

    @Query(value = "SELECT * FROM images i WHERE i.product_id = ?1", nativeQuery = true)
    fun getSpecificBanners(id:Int) : List<Images>

}