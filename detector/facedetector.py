#!/usr/bin/python3
import cv2
import numpy as np

face_classifier = cv2.CascadeClassifier('haarcascade_frontalface_default.xml')

''' Receives an image, and returns a list of tuples with the form (x,y,w,h) 
where x,y are the coordinates for the face square and w,h are width and height respectively. 
This tuple is then sent back to the rest service in json format. ''''
def face_detector(img,size=0.5):
    gray = cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)
    faces = face_classifier.detectMultiScale(gray,1.3,5)
    faces_res = []
    return faces
   # if faces is ():
   #     return []
   # print(faces)
   # for (x,y,w,h) in faces:
        #x = x-100
        #w = w+100
        #y = y-100
        #h = h + 100
        #faces_res.append()
    #    cv2.rectangle(img,(x,y),(x+w,y+h),(255,0,0),2)
        #roi_gray = gray[y:,y+h,x:,x+w]
        #roi_color = img[y:y+h,x:x+w]
        #eyes = eye_classifier.detectMultiScale(roi_gray)
        
       # for (ex,ey,ew,eh) in eyes:
        #    cv2.rectangle(roi_color,(ex,ey),(ex+ew,ey+eh),(0,0,255),2)
        #    roi_color = cv2.flip(roi_color,1)
   # return img

#img = cv2.imread("test_2.jpg")
#img = cv2.resize(img,(0,0),fx=0.27,fy=0.19)
#cv2.imshow('imagen original',img)
#res_img = face_detector(img)
#cv2.imshow('imagen detectada',res_img)

#cv2.waitKey(0)
#cv2.destroyAllWindows()
