package com.bridgelabz.stock;
import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StockPortfolio {
	
	public String shareName;
	public int noOfShare;
	public double sharePrice;
	public double totalShareValue;
	
	private List<Stock> stocks;
	
	public StockPortfolio() {
		stocks = new ArrayList<>();
	}
	

	public void readFileInput() throws Exception {
		String filePath = "C:\\Users\\91897\\Desktop\\Projects\\Learning_path\\RFT_JAVA_80\\JavaStockAccountManagement\\src\\com\\bridgelabz\\stock\\stockinfo";
		List<String> lines = new ArrayList<String>();
		Path path = Paths.get(filePath);
		lines = Files.readAllLines(path);

		System.out.println(lines);
		for (String line : lines) {
			String[] word = line.split(" ");
			 shareName = word[0];
			 noOfShare = Integer.valueOf(word[1]);
			 sharePrice = Double.valueOf(word[2]);
			 totalShareValue = Integer.valueOf(word[1]) * Double.valueOf(word[2]);
			 Stock stock = new Stock(shareName, noOfShare, sharePrice, totalShareValue);
			 stocks.add(stock);

		}
	}
	
	public void writeDataIntoFile() throws Exception{
		String filepath = "C:\\\\Users\\\\91897\\\\Desktop\\\\Projects\\\\Learning_path\\\\RFT_JAVA_80\\\\JavaStockAccountManagement\\\\src\\\\com\\\\bridgelabz\\\\stock\\\\stockshareprice";
		BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
		for (Stock s : stocks) {
			writer.write(s + System.lineSeparator());
		}
		
		writer.close();
		
	}

}
