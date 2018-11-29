package com.erp.dto.reponse;

import lombok.*;

//http://www.cnblogs.com/tabCtrlShift/p/9076559.html
/*顾名思义：NoArgsConstructor 生成无参数构造函数，AllArgsConstructor 生成全部参数构造函数，RequiredArgsConstructor生成@NonNull注解字段的构造函数。*/
@NoArgsConstructor
@AllArgsConstructor
@Data //等同于@ToString, @EqualsAndHashcode, @Getter, @Setter和@RequiredArgsConstructor一起使用
public class MyLombokRep {

   public  Integer  id;

    public  String name;

    public  String nickName;
}
