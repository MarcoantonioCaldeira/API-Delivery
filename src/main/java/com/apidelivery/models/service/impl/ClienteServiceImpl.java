package com.apidelivery.models.service.impl;
import java.util.Optional;

import com.apidelivery.models.model.EnderecoCliente;
import com.apidelivery.models.model.FormaPagamento;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.apidelivery.models.data.ClienteRequest;
import com.apidelivery.models.data.ClienteResponse;
import com.apidelivery.models.model.Cliente;
import com.apidelivery.models.repository.ClienteRepository;
import com.apidelivery.models.service.ClienteService;
import com.apidelivery.models.service.exception.EntityNotFoundException;
import com.apidelivery.models.service.mapper.EntityConversor;
import com.apidelivery.models.service.exception.PasswordConfirmationException;
import com.apidelivery.models.service.exception.EmailAlreadyExistsException;


@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EntityConversor entityConversor;


    @Override
    public ClienteResponse save(ClienteRequest entity) {
        Cliente cliente = entityConversor.parseObject(entity, Cliente.class);

        Optional<Cliente> userSaved = clienteRepository.findByEmail(cliente.getEmail());
        if(userSaved.isPresent() && userSaved.get().equals(cliente)) {
            throw new EmailAlreadyExistsException("O email informado já está cadastrado");
        }
        if(!entity.getSenha().equals(entity.getConfirmarSenha())) {
           throw new PasswordConfirmationException("A senha de confirmação e a senha não conferem");
        }

        cliente = clienteRepository.save(cliente);
        ClienteResponse clienteResponse = entityConversor.parseObject(cliente, ClienteResponse.class);

        return clienteResponse;
    }

    @Override
    public ClienteResponse update(Long id, ClienteRequest entity) {

        Cliente cliente  = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(("Entidade não encontrada")));
        Cliente clienteConv = entityConversor.parseObject(entity, Cliente.class);

        if(!entity.getSenha().equals(entity.getSenha())) {
            throw new PasswordConfirmationException("A senha de confirmação e a senha não conferem");
        }

        cliente.setConfirmarSenha(entity.getConfirmarSenha());
        cliente.setEmail(entity.getEmail());
        cliente.setSenha(entity.getSenha());
        cliente.setNome(entity.getNome());

        cliente = clienteRepository.saveAndFlush(cliente);
        ClienteResponse clienteResponse = entityConversor.parseObject(clienteConv, ClienteResponse.class);

        return clienteResponse;

    }


    private EnderecoCliente atualizarEndereco(EnderecoCliente endereco, String attributeValue) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            EnderecoCliente novoEndereco = objectMapper.readValue(attributeValue, EnderecoCliente.class);

            if (novoEndereco.getCep() != null) {
                endereco.setCep(novoEndereco.getCep());
            }
            if (novoEndereco.getUF() != null) {
                endereco.setUF(novoEndereco.getUF());
            }
            return endereco;
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Erro ao processar os dados do endereço: " + e.getMessage());
        }
    }

    private FormaPagamento atualizarFormaPagamento(FormaPagamento pagamento, String attributeValue) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            FormaPagamento formaPagamento = objectMapper.readValue(attributeValue, FormaPagamento.class);

            if (formaPagamento.getCpf_cnpj() != null) {
                pagamento.setCpf_cnpj(formaPagamento.getCpf_cnpj());
            }
            if (formaPagamento.getNum_cartao() != null) {
                pagamento.setNum_cartao(formaPagamento.getNum_cartao());
            }
            return pagamento;
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Erro ao processar os dados do endereço: " + e.getMessage());
        }
    }



    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteResponse read(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));

        return entityConversor.parseObject(cliente, ClienteResponse.class);
    }

}
