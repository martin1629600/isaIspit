//package com.example.isa.services;
//
//import com.example.isa.models.UserModel;
//import com.example.isa.models.UserPageModel;
//import com.example.isa.models.UserProductsModel;
//import com.example.isa.repositories.IUserProductsRepository;
//import com.example.isa.repositories.IUserRepository;
//import lombok.RequiredArgsConstructor;
//import mappers.UserMapper;
//import mappers.UserProductsMapper;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class UserService implements IUserService{
//    private final IUserRepository userRepository;
//    private final IUserProductsRepository userProductsRepository;
//
//    @Override
//    public List<UserModel> findAll(){
//        var result = userRepository.findAll();
//        return UserMapper.toModelList(result);
//    }
//
//    @Override
//    public UserPageModel findPagedList(PageRequest pageRequest){
//        var result = userRepository.findAll(pageRequest);
//        return UserMapper.toModelPagedList(result);
//    }
//
//    @Override
//    public UserModel create(UserModel model){
//        var entity = UserMapper.toEntity(model);
//        return UserMapper.toModel(userRepository.save(UserMapper.toEntity(model)));
//    }
//
//    @Override
//    public UserModel update(UserModel model){
//        var entity = UserMapper.toEntity(model);
//        var result = userRepository.save(entity);
//        return UserMapper.toModel(result);
//    }
//
//    @Override
//    public List<UserProductsModel> findUserProductsAll(){
//        var result = userProductsRepository.findAll();
//        return UserProductsMapper.toModelList(result);
//    }
//
//
//    public void delete(Integer id){
//        userRepository.deleteById(id);
//    }
//}
