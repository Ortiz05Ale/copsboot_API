package mx.uv.ale.copsboot.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.UUID;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import mx.uv.ale.copsboot.jpa.UniqueIdGenerator;
import mx.uv.ale.copsboot.user.User;
import mx.uv.ale.copsboot.user.UserRepository;
import mx.uv.ale.copsboot.user.UserRole;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DataJpaTest
public class UserRepositoryTest {
    
    @Autowired
    private UserRepository repository;

    @Test
    public void testStoreUser(){
        HashSet<UserRole> roles = new HashSet<>();
        roles.add(UserRole.OFFICER);
        User user = repository.save(new User(repository.nexId(),
                                    "alex.foley@beverly-hills.com",
                                    "my-secret-pwd",
                                    roles));
        assertThat(user).isNotNull();
        assertThat(repository.count()).isEqualTo(1L);
    }

    @TestConfiguration
    static class TestConfig{
        @Bean
        public UniqueIdGenerator<UUID> generator(){
            return new InMemoryUniqueIdGenerator();
        }
    }
}

