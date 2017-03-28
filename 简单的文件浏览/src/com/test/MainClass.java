package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 简单的文件浏览器
 * 
 * @author hdy
 * 
 */
public class MainClass {
	private static Scanner scanner = new Scanner(System.in);
	private static boolean flag = true;

	public static void main(String[] args) throws IOException {
		start();
	}

	@SuppressWarnings("resource")
	public static void start() throws IOException {
		while (flag) {
			System.out.println("请输入您要浏览的文件.");
			String nextLine = scanner.nextLine();
			// 判断输入的是否有问题:
			if (nextLine != null && !nextLine.isEmpty()) {
				File file = new File(nextLine);
				// 判断是否为文件并且文件存在:
				if (file.exists() && file.isFile()) {
					// 重点*******************************
					// 获取一个文件输入流
					FileInputStream fileInputStream = new FileInputStream(file);
					// 获取一个字符输入流
					InputStreamReader inputStreamReader = new InputStreamReader(
							fileInputStream);
					// 获取一个输入缓冲流
					BufferedReader reader = new BufferedReader(
							inputStreamReader);
					// 按行获取内容
					while (true) {
						// 循环读取一行的内容.打印出来
						String line = reader.readLine();
						if (line == null) {
							break;
						}
						System.out.println(line);
					}
					// 重点*******************************
				} else {
					System.out.println("文件不存在或者不为文件夹!");
				}
			} else {
				System.out.println("输入的有误,请重新输入!");
			}
		}
	}
}
