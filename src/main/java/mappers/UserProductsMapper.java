//package mappers;
//
//import com.example.isa.entities.UserVinyls;
//import com.example.isa.models.UserProductsModel;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserProductsMapper {
//    public static UserProductsModel toModel(UserVinyls entity){
//        return UserProductsModel.builder()
//                .id(entity.getId())
//                .email(entity.getEmail())
//                .firstName(entity.getFirstName())
//                .lastName(entity.getLastName())
//                .products(VinylMapper.toModelList(entity.getProducts()))
//                .build();
//    }
//
//    public static List<UserProductsModel> toModelList(List<UserVinyls> entities){
//        var list = new ArrayList<UserProductsModel>();
//        for(var entity : entities){
//            list.add(toModel(entity));
//        }
//        return list;
//    }
//}
