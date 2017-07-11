@ResponseBody
@RequestMapping("/{% interfaceName %}")
@ApiOperation(value = "{% interfaceDescription %}", httpMethod = "POST", response = JsonBean.class, notes = "{% interfaceDescription %}")
public JsonBean {% interfaceName %}(
      {% interfaceApiParams %}
) {
    JsonBean jsonBean = new JsonBean();
    try {

        String str = geotmtServiceImpl.{% interfaceName %}({% interfaceReferenceParams %});

        jsonBean.setCode(10000);
        jsonBean.setData(JSON.parse(str));

    } catch (Exception e) {
        e.printStackTrace();
        jsonBean.setCode(-1);
        jsonBean.setMessage(e.getMessage());
    }
    return jsonBean;
}