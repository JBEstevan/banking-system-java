package jbank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import jbank.exception.ContaNaoEncontradaException;
import jbank.exception.SaldoInsuficienteException;

public class AgenciaBancaria {

	static Scanner entrada = new Scanner(System.in);
	static Map<Integer, Conta> contasBancarias;

	public static void main(String[] args) {
		contasBancarias = new HashMap<>();
		operacoes();
	}

	public static void operacoes() {
		System.out.println("========== ========== ==========");
		System.out.println("========== Bem vindo ==========");
		System.out.println("========== ========== ==========\n");
		System.out.println("========== Selecione a opção desejada ==========");
		System.out.println("========== 1 - Criar Conta ==========");
		System.out.println("========== 2 - Depositar ==========");
		System.out.println("========== 3 - Sacar ==========");
		System.out.println("========== 4 - Transferir ==========");
		System.out.println("========== 5 - Listar ==========");
		System.out.println("========== 6 - Sair ==========");

		int operacao = entrada.nextInt();

		switch (operacao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listarContas();
			break;
		case 6:
			System.out.println("Até a próxima.");
			System.exit(0);
		default:
			System.out.println("Opção inválida");
			break;
		}
	}

	public static void criarConta() {
		System.out.println("===== Informe os dados abaixo =====\n");
		System.out.println("Nome: \n");
		String nome = entrada.next();

		System.out.println("CPF: \n");
		String cpf = entrada.next();

		System.out.println("Email: \n");
		String email = entrada.next();

		Cliente cliente = new Cliente(nome, cpf, email);
		Conta conta = new Conta(cliente);

		contasBancarias.put(conta.getNumeroConta(), conta);
		System.out.println("Conta criada com sucesso! O número da sua conta é " + conta.getNumeroConta());
		operacoes();
	}

	private static Conta encontrarConta(int numeroConta) throws ContaNaoEncontradaException {
		Conta conta = contasBancarias.get(numeroConta);
		if (conta == null) {
			throw new ContaNaoEncontradaException("Erro: A conta número " + numeroConta + " não foi encontrada.");
		}
		return conta;
	}

	public static void depositar() {
		System.out.println("Informe o número da conta: ");
		int numeroConta = entrada.nextInt();

		try {
			Conta conta = encontrarConta(numeroConta);
			System.out.println("Qual valor deseja depositar? ");
			Double valorDeposito = entrada.nextDouble();
			conta.depositar(valorDeposito);
		} catch (ContaNaoEncontradaException e) {
			System.out.println(e.getMessage());
		}
		operacoes();
	}

	public static void sacar() {
		System.out.println("Informe o número da conta: ");
		int numeroConta = entrada.nextInt();

		try {
			Conta conta = encontrarConta(numeroConta);
			System.out.println("Qual valor deseja sacar? ");
			Double valorSaque = entrada.nextDouble();
			conta.sacar(valorSaque);
		} catch (ContaNaoEncontradaException | SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}
		operacoes();
	}

	public static void transferir() {
		System.out.println("Informe o seu número de conta: ");
		int numeroConta = entrada.nextInt();

		try {
			Conta conta = encontrarConta(numeroConta);

			System.out.println("Informe o número da conta deseja transferir: ");
			int numeroContaDestino = entrada.nextInt();

			Conta contaDestino = encontrarConta(numeroContaDestino);

			System.out.println("Informe o valor da transferência: ");
			Double valor = entrada.nextDouble();

			conta.transferir(contaDestino, valor);

		} catch (ContaNaoEncontradaException | SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}
		operacoes();
	}

	public static void listarContas() {
		if (!contasBancarias.isEmpty()) {
			for (Conta conta : contasBancarias.values()) {
				System.out.println(conta);
			}
		} else {
			System.out.println("Não há contas cadastradas.");
		}
		operacoes();
	}
}
