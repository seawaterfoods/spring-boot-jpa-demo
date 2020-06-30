package com.joe.domain;

import javax.persistence.*;
import java.util.Date;

//@Table可以更改數據表名稱
//@Table(name = "t_author")
@Entity
public class Author {

//    @GeneratedValue可以指定該key值的生成方式，@GeneratedValue(strategy=GenerationType.XXX)
//    默認為AUTO，
//    IDENTITY採取數據庫ID自動增長來生成PKey，Oracle不支援
//    SEQUENCE通過序列產生PKey，通過SequenceGenerator註解指定序列名，MySQL不支援
//    TABLE採用表生成方式來生成PKey，此方式較為通用，但效率較差

//    @Basic(fetch=XXX , optional=XXX)默認皆預設，
//    有兩個屬性值fetch & optional，
//    fetch有EAGER:主動抓取值 LAZY延遲抓取值當有用到get該屬性時才取值，
//    optional表示該屬性是否允許null，默認為true。

//    @Column可以指定數據表中該屬性名稱組成方式，@Column(name=xxx,nullable=xxx,unique=xxx,length=xxx,insertable=xxx,updateable=xxx,columnDefinition=xxx)
//    name表示DB中table欄位名稱
//    unique表示是否為唯一，默認false
//    length表示字段的大小，僅對String有效
//    insertable表示在ORM框架執行插入操作時，該字段是否應出現INSETRT語句中，默認ture
//    updateable表示在ORM框架執行更新操作時，該字段是否應出現UPDATE語句中，默認ture
//    columnDefinition表示該字段在數據庫中的實際類型，通常ORM框架可以根據屬性類型自動判斷數據控中的字段類型，
//    但也有例外:
//    Date類型無法確認數據庫中字段類型究竟是DATE or TIME or TIMESTAMP，
//    String的默認映射為VARCHAR，如果希望將String類型映射到特定資料庫的BLOB or TEXT字段類型，則需要進行設置。


//    @Transient不會去將此屬性映射到Table中
//　 　@Temporal(TemporalType.XXX)指定時間映射類型
//    @Lob表示將屬性映射到資料庫時設置成大數據類型(長字串之類的)，通常搭配fetch:LAZY

    @Id
    @GeneratedValue
    private Long id;
    private String nickName;
    private String phone;

    @Temporal(TemporalType.DATE)
    private Date signDate;

//    @OneToOne(cascade = {CascadeType.XXX,CascadeType.XXX})
//    給予此物件實體操作另一物件的權限，
//    CascadeType.PERSIST級聯保存，給予可於資料庫中保存此時物件的權限
//    CascadeType.MERGE級聯合併，給予可於資料庫中改變此物件的權限
//    CascadeType.REMOVE級聯刪除，給予可於資料庫中刪除此物件的權限
//    CascadeType.DETACH級聯脫去關聯，如果要刪除一個實體物件但有FKey所以無法刪除，
//    但此操作可以自動撤銷所有關聯的FKey權限。
//    CascadeType.REFRESH級聯刷新操作，假設有多人同時操作同一物件時，要先刷新最新已保存之物件後，才可以保存同一物件。
//    CascadeType.ALL擁有以上所有權限。
//    @JoinColumn(name = "xxxxx")可指定FKey關聯字段名字
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private Wallet wallet;

//    關於構造函式，因Hibernate是應用到無參數建構子反射到數據庫，所以一定要建一個無參數建構子。
    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", signDate=" + signDate +
                '}';
    }
}
