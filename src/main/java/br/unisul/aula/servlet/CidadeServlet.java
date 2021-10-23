package br.unisul.aula.servlet;

import br.unisul.aula.banco.ClienteDAO;
import br.unisul.aula.banco.EnderecoDAO;
import br.unisul.aula.dtos.ClienteCidadeDTO;
import br.unisul.aula.dtos.EnderecoDTO;
import br.unisul.aula.modelo.CidadeCLiente;
import br.unisul.aula.modelo.Cliente;
import br.unisul.aula.modelo.Endereco;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@WebServlet(name = "CidadeServlet", value = "/Cidade")
public class CidadeServlet extends HttpServlet {
    private final EnderecoDAO enderecoDAO = new EnderecoDAO();
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        CidadeCLiente cidadeCliente = consultarCidade(request);
        String cidadeCLientes = gson.toJson(cidadeCliente);
        response.getWriter().println(cidadeCLientes);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private CidadeCLiente consultarCidade(HttpServletRequest request) {
        String cidade = request.getParameter("nomeCidade");
        Endereco endereco = enderecoDAO.findByCidade(cidade);

        List<ClienteCidadeDTO> clientesDaCidade = consultarClientePorCidade(cidade);
        CidadeCLiente cidadeCLiente = new CidadeCLiente();

        cidadeCLiente.setCidade(endereco.getCidade());
        cidadeCLiente.setUf(endereco.getUf());
        cidadeCLiente.setClientes(clientesDaCidade);
        return cidadeCLiente;
    }

    private List<ClienteCidadeDTO> consultarClientePorCidade(String cidade) {
        List<Cliente> clientes = clienteDAO.findByCidade(cidade);
        List<ClienteCidadeDTO> clientesCidadeDto = new ArrayList<>();
        if(clientes.size() > 0){
            for (Cliente cliente: clientes) {
                clientesCidadeDto.add(new ClienteCidadeDTO(cliente.getId(), cliente.getNome()));
            }
        }
        return clientesCidadeDto;
    }
}
