package com.codeburger.codeburgerapi.repository;

import com.codeburger.codeburgerapi.dto.response.MasMenuDetailResponse;
import com.codeburger.codeburgerapi.dto.response.MasMenuHeaderResponse;
import com.codeburger.codeburgerapi.entity.MasMenu;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MasMenuRepository extends MongoRepository<MasMenu, String> {

    @Aggregation(pipeline = {
            "{ $unwind: { path: '$ingredients', preserveNullAndEmptyArrays: true } }",
            "{ $lookup: { from: 'mas_ingredient', localField: 'ingredients.name', " +
                    "foreignField: 'name', as: 'matched' } }",
            "{ $unwind: { path: '$matched', preserveNullAndEmptyArrays: true } }",
            "{ $project: {  _id: 1, name: 1, category: 1, ingredient: { " +
                    "name: '$ingredients.name',  amount: '$ingredients.amount', " +
                    "pricePerUnit: '$matched.price', lineTotal: { $cond: " +
                    "[ { $and: [ { $ne: ['$matched.price', null] }, { $ne: ['$ingredients.amount', null] } ] }, " +
                    "{ $multiply: ['$matched.price', '$ingredients.amount'] }, null ] } } } }",
            "{ $group: { _id: '$_id', name: { $first: '$name' }, category: { $first: '$category' }, " +
                    "totalPrice: { $sum: { $ifNull: ['$ingredient.lineTotal', 0] } } } }",
            "{ $project: { _id: 0, id: { $toString: '$_id' }, name: 1, category: 1, totalPrice: 1 } }"
    })
    List<MasMenuHeaderResponse> findAllHeaders();

    @Aggregation(pipeline = {
            "{ $unwind: { path: '$ingredients', preserveNullAndEmptyArrays: true } }",
            "{ $lookup: { from: 'mas_ingredient', localField: 'ingredients.name', " +
                    "foreignField: 'name', as: 'matched' } }",
            "{ $unwind: { path: '$matched', preserveNullAndEmptyArrays: true } }",
            "{ $project: {  _id: 1, name: 1, category: 1, ingredient: { " +
                    "name: '$ingredients.name',  amount: '$ingredients.amount', " +
                    "pricePerUnit: '$matched.price', lineTotal: { $cond: " +
                    "[ { $and: [ { $ne: ['$matched.price', null] }, { $ne: ['$ingredients.amount', null] } ] }, " +
                    "{ $multiply: ['$matched.price', '$ingredients.amount'] }, null ] } } } }",
            "{ $group: { _id: '$_id', name: { $first: '$name' }, category: { $first: '$category' }, " +
                    "ingredients: { $push: '$ingredient' }, totalPrice: {" +
                    "$sum: { $ifNull: ['$ingredient.lineTotal', 0] } } } }",
            "{ $project: { _id: 0, id: { $toString: '$_id' }, name: 1, category: 1," +
                    "ingredients: 1, totalPrice: 1 } }"
    })
    List<MasMenuDetailResponse> findAllDetails();

    Optional<MasMenu> findByName(String name);

    List<MasMenu> findByCategory(String category);

}
