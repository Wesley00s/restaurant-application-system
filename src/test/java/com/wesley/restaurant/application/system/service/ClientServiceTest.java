package service;

import com.wesley.restaurant.application.system.entity.Address;
import com.wesley.restaurant.application.system.entity.Client;
import com.wesley.restaurant.application.system.repository.ClientRepository;
import com.wesley.restaurant.application.system.services.implemented.ClientService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import java.beans.Customizer;
import java.lang.ref.Cleaner;
import java.util.Optional;
import java.util.Random;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {
    @Mock ClientRepository clientRepository;
    @InjectMocks ClientService clientService;

    @Test
    public void shouldCreateClient() {
        String fakeEmail = "johnson.well@gmail.com";
        Client fakeClient = buildClient(new Random().nextLong(), fakeEmail);

        when(this.clientRepository.save(any())).thenReturn(fakeClient);

        Client current = this.clientService.save(fakeClient);

        Assertions.assertThat(current).isNotNull();
        Assertions.assertThat(current).isSameAs(fakeClient);
        verify(this.clientRepository, times(1)).save(fakeClient);
    }

    @Test
    public void shouldFindClientById() {
        Long fakeId = new Random().nextLong();
        String fakeEmail = "johnson.well@gmail.com";
        Client fakeClient = buildClient(fakeId, fakeEmail);
        when(clientRepository.findById(fakeId)).thenReturn(Optional.of(fakeClient));

        Client current = clientService.findById(fakeId);
        Assertions.assertThat(current).isNotNull();
        Assertions.assertThat(current).isExactlyInstanceOf(Client.class);
        Assertions.assertThat(current).isSameAs(fakeClient);
        verify(clientRepository, times(1)).findById(fakeId);
    }

    @Test
    public void shouldDeleteClientById() {
        // given
        Long fakeId = new Random().nextLong();
        String fakeEmail = "johnson.well@gmail.com";
        Client fakeClient = buildClient(fakeId, fakeEmail);
        when(clientRepository.findById(fakeId)).thenReturn(Optional.of(fakeClient));

        // when
        Client current = clientService.findById(fakeId);
        Assertions.assertThat(current).isNotNull();
        clientService.deleteById(fakeId);

        // then
        verify(clientRepository, times(1)).deleteById(fakeId);
    }

    @Test
    public void shouldFindClientByEmail() {
        Long fakeId = new Random().nextLong();
        String fakeEmail = "johnson.well@gmail.com";
        UserDetails fakeClient = buildClient(fakeId, fakeEmail);
        when(clientRepository.findByEmail(fakeEmail)).thenReturn(fakeClient);

        UserDetails current = clientService.findByEmail(fakeEmail);
        Assertions.assertThat(current).isNotNull();
        Assertions.assertThat(current).isSameAs(fakeClient);

        verify(clientRepository, times(1)).findByEmail(fakeEmail);
    }


    private Address buildAddress() {
        return new Address(
                "Castanhal",
                "Heliolândia",
                "68745717"
        );
    }

    private Client buildClient(Long clientId, String email) {
        return new Client(
                clientId,
                "Well Johnson",
                "9137114468",
                email,
                "op6mt%bjkb",
                "705.436.610-75",
                buildAddress()
        );
    }
}
