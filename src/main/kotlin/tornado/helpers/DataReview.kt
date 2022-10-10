package tornado.helpers

import food.review.app.console.models.FoodReviewModel
import javafx.collections.FXCollections

class DataReview{
    fun addFoodReview(foodReview: FoodReviewModel){
        val conn = Database().conn
        val ps = conn.prepareStatement("insert into data(id,name ,address ,postCode ,justEatRating,items,price,comments,myRating)" +
                " values(?,?,?,?,?,?,?,?,?)")
        ps.setLong(1,foodReview.id)
        ps.setString(2,foodReview.name)
        ps.setString(3,foodReview.address)
        ps.setString(4,foodReview.postCode)
        ps.setDouble(5,foodReview.justEatRating)
        ps.setString(6,foodReview.items)
        ps.setDouble(7,foodReview.price)
        ps.setString(8,foodReview.comments)
        ps.setInt(9,foodReview.myRating)

        ps.executeUpdate()
        ps.close()
        conn.close()

    }

    fun listFoodReviews():List<FoodReviewModel>{
        val conn = Database().conn
        val resultSet = conn.createStatement().executeQuery("select * from data where number != 0 order by id")
        val foodReviews = ArrayList<FoodReviewModel>()
        while(resultSet.next()){
            val id = resultSet.getLong("id")
            val name = resultSet.getString("name")
            val address = resultSet.getString("address")
            val postCode = resultSet.getString("postCode")
            val justEatRating = resultSet.getDouble("justEatRating")
            val items = resultSet.getString("items")
            val price = resultSet.getDouble("price")
            val comments = resultSet.getString("comments")
            val myRating = resultSet.getInt("myRating")
            val foodReview = FoodReviewModel(id,name, address,postCode,justEatRating,items,price,comments,myRating)
            foodReviews.add(foodReview)
        }
        resultSet.close()
        conn.close()
        return foodReviews
    }

    fun deleteFoodReview(foodReview: FoodReviewModel){
        val conn = Database().conn
        val ps = conn.prepareStatement("delete from data where id = ?")
        ps.setLong(1, foodReview.id)
        ps.executeUpdate()
        ps.close()
        conn.close()
    }

    fun updateProduct(id:Long, foodReview: FoodReviewModel):FoodReviewModel{
        val conn = Database().conn
        val ps = conn.prepareStatement("update product name = ? ,address = ? ,postCode = ? ,justEatRating = ?,items = ?,price = ?,comments = ?,myRating = ?where id = ?")
        ps.setLong(1,id)
        ps.setString(2,foodReview.name)
        ps.setString(3,foodReview.address)
        ps.setString(4,foodReview.postCode)
        ps.setDouble(5,foodReview.justEatRating)
        ps.setString(6,foodReview.items)
        ps.setDouble(7,foodReview.price)
        ps.setString(8,foodReview.comments)
        ps.setInt(9,foodReview.myRating)
        ps.executeUpdate()
        ps.close()
        conn.close()
        return foodReview
    }

    fun searchProduct(id: Long):List<FoodReviewModel>{
        println(id)
        val conn = Database().conn
        val ps = conn.prepareStatement("select * from data where id like ?")
        ps.setString(1, "%$id%")
        val resultSet = ps.executeQuery()
        val searchFoodReviews = FXCollections.observableArrayList<FoodReviewModel>()
        while(resultSet.next()){
            val id = resultSet.getLong("id")
            val name = resultSet.getString("name")
            val address = resultSet.getString("address")
            val postCode = resultSet.getString("postCode")
            val justEatRating = resultSet.getDouble("justEatRating")
            val items = resultSet.getString("items")
            val price = resultSet.getDouble("price")
            val comments = resultSet.getString("comments")
            val myRating = resultSet.getInt("myRating")
            val foodReview = FoodReviewModel(id,name, address,postCode,justEatRating,items,price,comments,myRating)
            searchFoodReviews.add(foodReview)
        }
        resultSet.close()
        conn.close()
        return searchFoodReviews
    }

}