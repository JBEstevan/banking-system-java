package jbank;

import jbank.exception.SaldoInsuficienteException;
import jbank.util.Utils;

public class Conta {

	private static int contadorContas = 1;

	private int numeroConta;
	private Cliente cliente;
	private Double saldo = 0.0;

	public Conta(Cliente cliente) {
		this.numeroConta = contadorContas;
		this.cliente = cliente;
		contadorContas++;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "\n Numero da Conta: " + numeroConta + "\n Nome: " + this.cliente.getNome() + "\n CPF: "
				+ this.cliente.getCpf() + "\n Email: " + this.cliente.getEmail() + "\n Saldo: "
				+ Utils.doubleToString(getSaldo()) + "\n";
	}

	public void depositar(Double valor) {
		if (valor > 0) {
			this.saldo += valor;
			System.out.println("Depósito realizado com sucesso!");
		} else {
			System.out.println("Não foi possível realizar o depósito!");
		}
	}

	public void sacar(Double valor) throws SaldoInsuficienteException {
		if (valor <= 0) {
			System.out.println("Valor de saque inválido.");
			return;
		}
		if (this.saldo < valor) {
			throw new SaldoInsuficienteException("Erro: Saldo insuficiente para realizar a operação.");
		}
		this.saldo -= valor;
		System.out.println("Saque realizado com sucesso!");
	}

	public void transferir(Conta contaParaDeposito, Double valor) throws SaldoInsuficienteException {
		if (this.saldo < valor) {
			throw new SaldoInsuficienteException("Erro: Saldo insuficiente para transferência.");
		}
		if (valor <= 0) {
			System.out.println("Valor de transferência inválido.");
			return;
		}
		this.saldo -= valor;
		contaParaDeposito.depositar(valor);
		System.out.println("Transferência realizada com sucesso!");
	}

}
