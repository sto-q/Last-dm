package com.cry.pokrmon.item.Pokemon;

import com.cry.pokrmon.item.Item;
import com.cry.pokrmon.item.Monster;
import com.cry.pokrmon.item.equipment.*;

/*
宠物小精灵
 */
public abstract class pokemon extends Item {
    protected int attack;//攻击力
    protected int defense;//防御力
    protected int health;//生命值
    /*
    当前生命值
     */
    protected int currentHealth;
    public int getAttack() {
        int totalatttack=attack;
        for(Equipment equipment:equipments){
            if(equipment!=null){
            attack+=equipment.getAttack();
            }
        }
        return totalatttack;
    }
/*
返回所有装备共有防御值
 */
    public int getDefense() {
        int totaldefense=defense;
        for(Equipment equipment:equipments){
            if(equipment!=null){
            defense+=equipment.getDefense();
            }
        }
        return totaldefense;
    }
/*
返回总共生命值
 */
    public int getHealth() {
        int totalhealth=health;
        for(Equipment equipment:equipments){
            if(equipment!=null) {
                health += equipment.getHealth();
            }
        }
        return totalhealth;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Equipment[] getEquipments() {
        return equipments;
    }

    /*
         小精灵的等级
          */
    private  int star=1;
    /*
    默认小精灵可以穿戴8种装备，默认为空
    穿戴顺序：头盔，铠甲，护腿，靴子，武器，项链，戒指，手镯
     */
    protected Equipment[] equipments=new Equipment[8];

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }//得到当前生命值

    public void attackMonsters(Monster monster) {
        int minusHealth=this.attack*this.attack/ monster.getDefense();
        if(minusHealth==0)minusHealth=1;
        else if (minusHealth> monster.getCurrentHealth()) {
            minusHealth=monster.getCurrentHealth();
        }
        //剩余血量
        int restHealth= monster.getCurrentHealth()-minusHealth;
        monster.setCurrentHealth(restHealth);
        System.err.println(name+"对"+monster.getName()+"造成了"+minusHealth+"点伤害");
    }
    public pokemon(String name) {
        super(name);
    }
    @Override
    public String getItemInformation() {
        return name+"  攻击力:"+getAttack()+"防御力:"+getDefense()+"生命值:"+getHealth();
    }
    /*
    与其他小精灵融合
     */
    public void merge(pokemon other) {
        if(star==10) {
            System.out.println(name+"已经顶级了");
        }else {
            this.attack+=(other.attack>>1);
            this.defense+=(other.defense>>1);
            this.health+=(other.health>>1);
            star+=1;
            System.out.println("融合后信息：");
            System.out.println(getItemInformation());
            this.health=other.health;
        }
    }
    /*
    更换装备
     */
    public Equipment changeEquipment(Equipment newequipment) {
        int index=-1;
        if(newequipment instanceof Helmet){//头盔
            index=0;
        } else if (newequipment instanceof Armor) {//铠甲
            index=1;
        }else if (newequipment instanceof Leggings) {//护腿
            index=2;
        }else if (newequipment instanceof Shoe) {//靴子
            index=3;
        }else if (newequipment instanceof weapon) {//武器
            index=4;
        }else if (newequipment instanceof Nexklace) {//项链
            index=5;
        }else if (newequipment instanceof Ring) {//戒指
            index=6;
        }else{//手镯
            index=7;
        }
        Equipment oldequipment=equipments[index];
        if(oldequipment==null) {//未穿戴
            equipments[index]=newequipment;
        }else{//已经穿戴
            if(newequipment.isBetter(oldequipment)) {
                equipments[index]=newequipment;
            }else{
                oldequipment=newequipment;
            }
        }
        return oldequipment;
    }
    //获取生命值百分比
    public double getHealthpercent() {
        return currentHealth*1.0/getHealth();
    }
}
