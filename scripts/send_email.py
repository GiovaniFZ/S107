import os
import subprocess

def send_email(to_email):
    subject = "Pipeline Executado"
    body = "Pipeline executado com sucesso!"

    # mensagem
    message = f"Subject: {subject}\n\n{body}"

    # Usar sendmail para enviar o e-mail
    process = subprocess.Popen(
        ["/usr/sbin/sendmail", to_email],
        stdin=subprocess.PIPE,
        stdout=subprocess.PIPE,
        stderr=subprocess.PIPE
    )
    stdout, stderr = process.communicate(input=message.encode())

    if process.returncode == 0:
        print(f"E-mail enviado com sucesso para {to_email}")
    else:
        print(f"Falha ao enviar e-mail: {stderr.decode()}")

if __name__ == "__main__":
    commit_author_email = os.getenv('COMMIT_AUTHOR_EMAIL')
    send_email(commit_author_email)
