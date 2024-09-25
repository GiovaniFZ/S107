import smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart

def send_email():
    # Informações do servidor de e-mail (SMTP)
    smtp_server = "smtp.gmail.com"  # Servidor SMTP, aqui usado o Gmail
    smtp_port = 587  # Porta SMTP
    email_sender = "seu-email@gmail.com"
    email_password = "sua-senha-aqui"
    
    # Informações do destinatário
    email_recipient = "destinatario@gmail.com"
    
    # Criação do conteúdo do e-mail
    subject = "Informações sobre a execução do Pipeline"
    body = "Pipeline executado com sucesso!"
    
    # Criação da mensagem
    msg = MIMEMultipart()
    msg['From'] = email_sender
    msg['To'] = email_recipient
    msg['Subject'] = subject
    
    # Anexar o corpo do e-mail
    msg.attach(MIMEText(body, 'plain'))

    try:
        # Conectar ao servidor SMTP e enviar o e-mail
        server = smtplib.SMTP(smtp_server, smtp_port)
        server.starttls()  # Iniciar TLS para segurança
        server.login(email_sender, email_password)  # Login no servidor SMTP
        text = msg.as_string()
        server.sendmail(email_sender, email_recipient, text)  # Enviar o e-mail
        print("E-mail enviado com sucesso!")
    except Exception as e:
        print(f"Erro ao enviar e-mail: {str(e)}")
    finally:
        server.quit()
