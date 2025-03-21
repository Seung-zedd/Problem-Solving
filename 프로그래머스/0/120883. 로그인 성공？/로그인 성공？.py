def solution(id_pw, db):
    for id, pw in db:
        if id == id_pw[0] and pw == id_pw[1]:
            return "login"
        elif id == id_pw[0] and pw != id_pw[1]:
            return "wrong pw"
    return "fail"