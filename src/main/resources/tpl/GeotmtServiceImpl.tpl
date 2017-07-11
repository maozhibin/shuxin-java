public String {% interfaceName %}({% interfaceParams %}) {
    logger.info(client);
    // 请求地址
    String path = server + "/civp/getview/api/u/queryUnify";
    // 请求参数(client里面会自动加密,所以这里请使用明文)
    Map<String, String> params = new HashMap<String, String>();
    {% interfaceChildrenParams %}
    params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
    // 请求数据接口返回json
    String data = client.getData(path, params);
    return simplyOutput(data);
}