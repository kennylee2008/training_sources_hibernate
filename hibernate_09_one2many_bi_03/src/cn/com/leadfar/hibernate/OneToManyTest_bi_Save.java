package cn.com.leadfar.hibernate;

import junit.framework.TestCase;

import org.hibernate.Session;

public class OneToManyTest_bi_Save extends TestCase {
	
	public void testOneToManyBiSave01(){
		//����Hibenate Session
		Session session = HibernateUtil.openSession();
		
		try{
			//��������
			session.beginTransaction();
			
			//******************* �Ӷ��һ�˹�������֮��Ĺ�����ϵ ***********************//
			Group g1 = new Group("����");
			session.save(g1);//g1����˳־û�����״̬������ӵ�������ݿ��ʶ
			Group g2 = new Group("İ����");
			session.save(g2);//g2����˳־û�����״̬������ӵ�������ݿ��ʶ
			Group g3 = new Group("����");
			session.save(g3);//g3����˳־û�����״̬������ӵ�������ݿ��ʶ
			
			ContactPerson cp1 = new ContactPerson("�ȶ��Ǵ�");
			//����cp1��g1����֮��Ĺ���
			//���ԣ�hibernate�ܹ����ʵ�g1������g1�����ݿ��ʶ
			//����ӳ���ļ���ָʾ���洢��groupId�ֶ�
			cp1.setGroup(g1);
			session.save(cp1);//cp1����˳־û�����״̬������ӵ�������ݿ��ʶ
			
			ContactPerson cp2 = new ContactPerson("�ͷ���");
			//����cp2��g1����֮��Ĺ���
			//���ԣ�hibernate�ܹ����ʵ�g1������g1�����ݿ��ʶ
			//����ӳ���ļ���ָʾ���洢��groupId�ֶ�
			cp2.setGroup(g1);
			session.save(cp2);//cp2����˳־û�����״̬������ӵ�������ݿ��ʶ
			
			ContactPerson cp3 = new ContactPerson("·�˼�");
			//����cp3��g2����֮��Ĺ���
			//���ԣ�hibernate�ܹ����ʵ�g2������g2�����ݿ��ʶ
			//����ӳ���ļ���ָʾ���洢��groupId�ֶ�
			cp3.setGroup(g2);			
			session.save(cp3);//cp3����˳־û�����״̬������ӵ�������ݿ��ʶ
			
			//�ύ����
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			//�����쳣����ع�����
			session.getTransaction().rollback();
		}finally{
			//�ر�session
			session.close(); 
		}
	}
	
	public void testOneToManyBiSave02(){
		//����Hibenate Session
		Session session = HibernateUtil.openSession();
		
		try{
			//��������
			session.beginTransaction();
			
			//��һ��һ��ȥ��������֮��Ĺ�����ϵ
			ContactPerson cp1 = new ContactPerson("�ȶ��Ǵ�");
			session.save(cp1);//cp1����˳־û�����״̬������ӵ�������ݿ��ʶ
			ContactPerson cp2 = new ContactPerson("�ͷ���");
			session.save(cp2);//cp2����˳־û�����״̬������ӵ�������ݿ��ʶ
			ContactPerson cp3 = new ContactPerson("·�˼�");
			session.save(cp3);//cp3����˳־û�����״̬������ӵ�������ݿ��ʶ
			
			Group g1 = new Group("����");
			g1.addPerson(cp1);
			g1.addPerson(cp2);
			session.save(g1);//g1����˳־û�����״̬������ӵ�������ݿ��ʶ
			
			Group g2 = new Group("İ����");
			session.save(g2);//g2����˳־û�����״̬������ӵ�������ݿ��ʶ
			
			Group g3 = new Group("����");
			g3.addPerson(cp3);
			session.save(g3);//g3����˳־û�����״̬������ӵ�������ݿ��ʶ			
			
			//�ύ����
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			//�����쳣����ع�����
			session.getTransaction().rollback();
		}finally{
			//�ر�session
			session.close(); 
		}
	}
	
	public void testOneToManyBiSave03(){
		//����Hibenate Session
		Session session = HibernateUtil.openSession();
		
		try{
			//��������
			session.beginTransaction();
			
			
			ContactPerson cp1 = new ContactPerson("�ȶ��Ǵ�");
			session.save(cp1);//cp1����˳־û�����״̬������ӵ�������ݿ��ʶ
			ContactPerson cp2 = new ContactPerson("�ͷ���");
			session.save(cp2);//cp2����˳־û�����״̬������ӵ�������ݿ��ʶ
			ContactPerson cp3 = new ContactPerson("·�˼�");
			session.save(cp3);//cp3����˳־û�����״̬������ӵ�������ݿ��ʶ
			
			Group g1 = new Group("����");
			g1.addPerson(cp1); //���������inverse="true"����������Ч��
			g1.addPerson(cp2);//���������inverse="true"����������Ч��
			session.save(g1);//g1����˳־û�����״̬������ӵ�������ݿ��ʶ
			
			cp1.setGroup(g1);
			cp2.setGroup(g1);
			
			Group g2 = new Group("İ����");
			session.save(g2);//g2����˳־û�����״̬������ӵ�������ݿ��ʶ
			
			Group g3 = new Group("����");
			g3.addPerson(cp3); //���������inverse="true"����������Ч��
			session.save(g3);//g3����˳־û�����״̬������ӵ�������ݿ��ʶ			
			
			cp3.setGroup(g3);
			
			//�ύ����
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			//�����쳣����ع�����
			session.getTransaction().rollback();
		}finally{
			//�ر�session
			session.close(); 
		}
	}
	
	public void testOneToManyBiUpdate01(){
		//����Hibenate Session
		Session session = HibernateUtil.openSession();
		
		try{
			//��������
			session.beginTransaction();
			
			//���û������inverse="true"����ô�ڸ���һ��һ�˵Ķ���ʱ��
			Group g1 = (Group)session.load(Group.class, 1);
			g1.setName("������");
			
			//�ύ����
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			//�����쳣����ع�����
			session.getTransaction().rollback();
		}finally{
			//�ر�session
			session.close(); 
		}
	}
	
	public void testOneToManyBiUpdate02(){
		//����Hibenate Session
		Session session = HibernateUtil.openSession();
		
		try{
			//��������
			session.beginTransaction();
			
			ContactPerson cp1 = new ContactPerson();
			cp1.setId(1);
			cp1.setName("�ȶ�");
			cp1.setAddress("����");
			cp1.setQq("qqqq");
			
			//��ס����������������
			Group g1 = new Group();
			g1.setId(1);
			cp1.setGroup(g1);
			
			session.update(cp1);
			
			//�ύ����
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			//�����쳣����ع�����
			session.getTransaction().rollback();
		}finally{
			//�ر�session
			session.close(); 
		}
	}
	
	public void testOneToManyBiUpdate03(){
		//����Hibenate Session
		Session session = HibernateUtil.openSession();
		
		try{
			//��������
			session.beginTransaction();
			
			Group g1 = new Group();
			g1.setId(1);
			g1.setName("����");
			
			//������inverse="true"֮���������뽫�����κ����ã�
			ContactPerson cp1 = new ContactPerson();
			cp1.setId(6);
			ContactPerson cp2 = new ContactPerson();
			cp1.setId(7);
			g1.addPerson(cp1);
			g1.addPerson(cp2);
			
			session.update(g1);
			
			//�ύ����
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			//�����쳣����ع�����
			session.getTransaction().rollback();
		}finally{
			//�ر�session
			session.close(); 
		}
	}
	
	public void testOneToManyBiLoad01(){
		//����Hibenate Session
		Session session = HibernateUtil.openSession();
		
		try{
			//��������
			session.beginTransaction();
			
			//����ContactPerson���󣬿��Եõ��������Group����
			ContactPerson cp1 = (ContactPerson)session.load(ContactPerson.class, 1);
			System.out.println(cp1.getName()+",���ڣ�"+cp1.getGroup().getName());
			
			//�ύ����
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			//�����쳣����ع�����
			session.getTransaction().rollback();
		}finally{
			//�ر�session
			session.close(); 
		}
	}
	
	public void testOneToManyBiLoad02(){
		//����Hibenate Session
		Session session = HibernateUtil.openSession();
		
		try{
			//��������
			session.beginTransaction();
			
			//����Group���󣬿��Եõ��������ContactPerson����
			Group g1 = (Group)session.load(Group.class,1);
			System.out.println(g1.getName()+",��������У�"+g1.getPersons().size()+"���û�");
			
			//�ύ����
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			//�����쳣����ع�����
			session.getTransaction().rollback();
		}finally{
			//�ر�session
			session.close(); 
		}
	}
	
}