package com.zhongzhi.json;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TestJSON {

	@Test
	public void testJson() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		final String TREE_MODEL_BINDING = "{\"treekey1\":\"treevalue1\",\"treekey2\":\"treevalue2\",\"children\":[{\"childkey1\":\"childkey1\"}]}";
		JsonNode rootNode = mapper.readTree(TREE_MODEL_BINDING);

		String treekey2value = rootNode.path("treekey2").textValue();//
		System.out.println("treekey2value:" + treekey2value);
		JsonNode childrenNode = rootNode.path("children");
		String childkey1Value = childrenNode.get(0).path("childkey1").textValue();
		System.out.println("childkey1Value:" + childkey1Value);

		// 创建根节点
		ObjectNode root = mapper.createObjectNode();
		// 创建子节点1
		ObjectNode node1 = mapper.createObjectNode();
		node1.put("nodekey1", 1);
		node1.put("nodekey2", 2);
		// 绑定子节点1
		root.set("child", node1);
		// 数组节点
		ArrayNode arrayNode = mapper.createArrayNode();
		arrayNode.add(node1);
		arrayNode.add(1);
		// 绑定数组节点
		root.set("arraynode", arrayNode);
		// JSON读到树节点
		//JsonNode valueToTreeNode = mapper.valueToTree(TREE_MODEL_BINDING);
		JsonNode valueToTreeNode = mapper.readTree(TREE_MODEL_BINDING);
		// 绑定JSON节点
		root.put("valuetotreenode", valueToTreeNode);
		// JSON绑定到JSON节点对象
		// JsonNode bindJsonNode = mapper.readValue(GENERIC_BINDING,
		// JsonNode.class);//绑定JSON到JSON节点对象.
		// 绑定JSON节点
		// root.put("bindJsonNode",bindJsonNode);
		System.out.println(mapper.writeValueAsString(root));
	}
	@Test
	public void testString() throws IOException {
		int number = 1;
        String id = String.format("%06d", number);
        
		long snumber = 1;
        String sid = String.format("%0100d", snumber);
        System.out.println(sid);		
	}
}
