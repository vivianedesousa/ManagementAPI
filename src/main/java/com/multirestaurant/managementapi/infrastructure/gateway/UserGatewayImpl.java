package com.multirestaurant.managementapi.infrastructure.gateway;
import com.multirestaurant.managementapi.domain.gateway.UserGateway;
import com.multirestaurant.managementapi.infrastructure.mapper.UserMapper;
import com.multirestaurant.managementapi.infrastructure.persistence.repository.UserJpaRepository;
import com.multirestaurant.managementapi.domain.model.User;
import com.multirestaurant.managementapi.infrastructure.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
 //"O GatewayImpl realiza a comunicação com o banco através do repository e utiliza o mapper para
 // converter entre domínio e entidade."
@Component
public class UserGatewayImpl implements UserGateway {

    private final UserJpaRepository repository;
    private final UserMapper userMapper;

    public UserGatewayImpl(UserJpaRepository repository, UserMapper userMapper) {
        this.repository = repository;
        this.userMapper = userMapper;
    }

    // ele levara a regra para dentro do DB
    // CREATE / UPDATE
    @Override
    public User save(User user) {
        UserEntity entity = userMapper.toEntity(user);
        UserEntity saved = repository.save(entity);
        return userMapper.toDomain(saved);
    }

    // READ ALL
    @Override
    public List<User> findAll() {
        return repository.findAll()
                .stream()
                .map(userMapper::toDomain)
                .toList();
    }

    // READ BY ID
    @Override
    public Optional<User> findById(Long id) {
        Optional<UserEntity> entity = repository.findById(id);
        if (entity.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(userMapper.toDomain(entity.get()));
    }

    // READ BY EMAIL
    @Override
    public Optional<User> findByEmail(String email) {
        Optional<UserEntity> entity = repository.findByEmail(email);
        if (entity.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(userMapper.toDomain(entity.get()));
    }

    // DELETE
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}